package d3.S10965;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_timeout {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br= new BufferedReader(new StringReader(src));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int result = 1;
			int number = Integer.parseInt(br.readLine());
			boolean[] check = new boolean[number + 1];
			check[1] = true;
			if ((int) Math.sqrt(number) == Math.sqrt(number)) {
				sb.append(result);
			} else {
				for (int i = 2; i <= number; i++) {
					if (number % i == 0) {
						check[i] = !check[i];
						number /= i;
						i = 1;
					}
				}
				for (int i = 2; i < check.length; i++) {
					if (check[i])
						result *= i;
				}
				sb.append(result);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

//	static String src = "8\r\n" + 
//			"1\r\n" + 
//			"2\r\n" + 
//			"3\r\n" + 
//			"4\r\n" + 
//			"5\r\n" + 
//			"6\r\n" + 
//			"60\r\n" + 
//			"1000\r\n";
}
