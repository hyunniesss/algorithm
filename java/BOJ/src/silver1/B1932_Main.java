package silver1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1932_Main {

	static int N;
	static int[][] triangle;

	public static void main(String[] args) {

		initInput();
		int answer = findMaxSum();
		System.out.println(answer);

	}

	private static int findMaxSum() {
		int[][] dp = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
			}
		}
		int max = getMaxSum(dp[N]);
		return max;
	}

	private static int getMaxSum(int[] dp) {
		Arrays.sort(dp);
		return dp[N];
	}

	private static void initInput() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		try {
			N = Integer.parseInt(br.readLine());
			triangle = new int[N + 1][N + 1];
			for (int i = 1; i <= N; i++) {
				str = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j <= i; j++) {
					triangle[i][j] = Integer.parseInt(str.nextToken());
				}
			}
		} catch (Exception e) {
		}

	}

}
