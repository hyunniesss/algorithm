package silver1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2156_Main {

	static int N;

	public static void main(String[] args) {
		int[] arr = initInput();
		int answer = findMaxVal(arr);
		System.out.println(answer);
	}

	private static int findMaxVal(int[] arr) {
		int[][] dp = new int[N + 1][2]; // 0 : 연속1, 1 : 연속2
		int max = 0;
		for (int i = 1; i <= N; i++) {
			dp[i][0] = max + arr[i - 1];
			dp[i][1] = dp[i - 1][0] + arr[i - 1];
			max = Math.max(max, Math.max(dp[i - 1][0], dp[i - 1][1])); // -2까지의 최대값
		}

		return findMax(dp);
	}

	private static int findMax(int[][] dp) {
		int max = -1;
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j < 2; j++) {
				max = max > dp[i][j] ? max : dp[i][j];
			}
		}
		return max;
	}

	private static int[] initInput() {
		int[] arr = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
		} catch (Exception e) {
		}

		return arr;
	}

}
