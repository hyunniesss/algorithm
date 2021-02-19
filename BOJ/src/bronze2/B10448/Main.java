package bronze2.B10448;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int[] T = new int[1001];
	static int R = 3, K;

	public static void main(String[] args) throws Exception {

		int add = 1;
		for (int i = 1; i <= 1000; i++) {
			T[i] = T[i - 1] + add;
			add++;
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			K = Integer.parseInt(br.readLine());
			if (combi(1, 0, 0)) { // 중복조합
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}

	}

	private static boolean combi(int cur, int cnt, int sum) {
		if (cnt == R) {
			if (sum == K) {
				return true;
			}
			return false;
		}

		for (int i = cur; i < 1001; i++) {
			if (sum + T[i] > K) {
				break;
			}
			if (combi(i, cnt + 1, sum + T[i])) {
				return true;
			}
		}

		return false;

	}

}
