package gold5.B1107;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		int now = 100;
		boolean[] check = new boolean[10];

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 이동하려는 채널

		int a = Integer.parseInt(br.readLine());
		if (a > 0) {
			StringTokenizer str = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < a; i++) {
				check[Integer.parseInt(str.nextToken())] = true;
			}
		}

		if (now == N) {
			System.out.println(0);
			return;
		}

		char[] temp = (N + "").toCharArray();
		int idx = 0;
		while (true) {
			boolean flag = true;
			for (int i = 0; i < temp.length; i++) {
				if (check[temp[i] - '0']) {
					flag = false;
					break;
				}
			}
			if (flag) {
				break;
			}

		}

	}

}
