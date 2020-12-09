package silver3.B1406;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_String_timeout {

	static int M;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new StringReader(src));

		String input = br.readLine();

		M = Integer.parseInt(br.readLine());
		int idx = input.length();
//		System.out.println(input);
		while (M-- > 0) {
			StringTokenizer str = new StringTokenizer(br.readLine(), " ");
			switch (str.nextToken()) {
			case "L":
				idx = idx > 0 ? idx - 1 : idx;
//				System.out.println("L : " + input);
				break;
			case "D":
				idx = idx == input.length() ? idx : idx + 1;
//				System.out.println("D : " + input);
				break;
			case "B":
				if (idx > 0) {
					String temp = input.substring(0, idx - 1);
					if (idx < input.length()) {
//						System.out.println("COME");
						temp += input.substring(idx);
					}
					input = new String(temp);
					idx--;
				}
//				System.out.println("B : " + input);
				break;
			case "P":
				input = new String(input.substring(0, idx) + str.nextToken() + input.substring(idx));
				idx = idx + 1;
//				System.out.println("P : " + input);
				break;
			}
		}

		System.out.println(input);

	}

	static final String src = "dmih\r\n" + "11\r\n" + "B\r\n" + "B\r\n" + "P x\r\n" + "L\r\n" + "B\r\n" + "B\r\n"
			+ "B\r\n" + "P y\r\n" + "D\r\n" + "D\r\n" + "P z\n";

}
