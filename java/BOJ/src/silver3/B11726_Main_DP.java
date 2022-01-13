package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11726_Main_DP {

	static int N, dp[];
	static final int MOD = 10007;

	public static void main(String[] args) {
		initInput();
		int answer = countTile(N);
		System.out.println(answer);
	}

	private static int countTile(int n) {
		if (dp[n] > 0) {
			return dp[n];
		}
		if (n < 2) {
			return dp[n] = 1;
		}
		return dp[n] = (countTile(n - 1) + countTile(n - 2)) % MOD;
	}

	private static void initInput() {

		try {
			N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
			dp = new int[N + 1];
		} catch (NumberFormatException | IOException e) {
		}

	}

}
