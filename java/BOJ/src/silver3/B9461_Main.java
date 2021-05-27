package silver3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B9461_Main {

	static long[] dp = new long[101];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		dp[3] = dp[2] = dp[1] = 1;
		dp[5] = dp[4] = 2;
		dp[6] = 3;
		dp[7] = 4;
		dp[8] = 5;
		dp[9] = 7;
		dp[10] = 9;

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			sb.append(wave(N)).append("\n");
		}

		System.out.println(sb.toString());
	}

	private static long wave(int n) {
		if (dp[n] != 0) {
			return dp[n];
		}
		return dp[n] = wave(n - 1) + wave(n - 5);
	}

}
