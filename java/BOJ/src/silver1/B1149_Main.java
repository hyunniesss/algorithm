package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1149_Main {

	static int N;
	static int[][] dp;

	public static void main(String[] args) {

		initInput();
		makeHouse();
		System.out.println(Math.min(dp[N - 1][0], Math.min(dp[N - 1][1], dp[N - 1][2])));
	}

	private static void makeHouse() {

		for (int i = 1; i < N; i++) {
			dp[i][0] += Math.min(dp[i - 1][1], dp[i - 1][2]);
			dp[i][1] += Math.min(dp[i - 1][0], dp[i - 1][2]);
			dp[i][2] += Math.min(dp[i - 1][0], dp[i - 1][1]);
		}

	}

	private static void initInput() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		try {
			N = Integer.parseInt(br.readLine());
			dp = new int[N][3];
			for (int i = 0; i < N; i++) {
				str = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 3; j++) {
					dp[i][j] = Integer.parseInt(str.nextToken());
				}
			}
		} catch (NumberFormatException | IOException e) {
		}

	}

}
