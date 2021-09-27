package silver5.B1059;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static boolean[] check = new boolean[1001];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		int L = Integer.parseInt(br.readLine());
		str = new StringTokenizer(br.readLine(), " ");
//		int min = 1000, max = -1;
		for (int i = 0; i < L; i++) {
			int temp = Integer.parseInt(str.nextToken());
			check[temp] = true;
//			min = Math.min(temp, min);
//			max = Math.max(temp, max);
		}

		int n = Integer.parseInt(br.readLine());
		int count = 0;
		for (int i = 1; i <= 1000; i++) {
			if (!check[i]) {
				int j = i;
				boolean flag = false;
				while (j < 1000 && !check[j]) {
					if (n == j) {
						flag = true;
					}
					j++;
				}
				if (!flag) {
					continue;
				}
				count += (j - n);
			}
		}

		System.out.println(count == 0 ? count : count - 1);

	}

}
