package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1003_Main {

	static int T, arr[];
	static int[][] dp;

	public static void main(String[] args) {
		initInput();
		StringBuilder sb = new StringBuilder();
		for (int a : arr) {
			int[] number = findFibo(a);
			sb.append(number[0]).append(" ").append(number[1]).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int[] findFibo(int a) {
		if (dp[a][0] >= 0) {
			return dp[a];
		}
		if (a == 1) {
			dp[1][0] = 0;
			dp[1][1] = 1;
			return dp[1];
		}
		if (a == 0) {
			dp[0][0] = 1;
			dp[0][1] = 0;
			return dp[0];
		}

		dp[a][0] = findFibo(a - 1)[0] + findFibo(a - 2)[0];
		dp[a][1] = findFibo(a - 1)[1] + findFibo(a - 2)[1];
		return dp[a];
//		return dp[a] = new int[]{ findFibo(a - 1)[0] + findFibo(a - 2)[0], findFibo(a - 1)[1] + findFibo(a - 2)[1]};
	}

	private static void initInput() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dp = new int[41][2];
		for (int i = 0; i < 41; i++) {
			Arrays.fill(dp[i], -1);
		}
		try {
			T = Integer.parseInt(br.readLine());
			arr = new int[T];
			for (int i = 0; i < T; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
		} catch (NumberFormatException | IOException e) {
		}

	}

}
