package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B5557_Main {

	static int[] arr;
	static int N;

	public static void main(String[] args) {

		int result = initInput();
		long count = makeOperation(result);
		System.out.println(count);

	}

	private static long makeOperation(int result) {

		long[][] dp = new long[N + 1][21]; // N개의 입력받은 수 와 나올 수 있는 결과
		dp[1][arr[1]] = 1;
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 21; j++) {
				if (dp[i - 1][j] == 0) {
					continue;
				}
				makeDP(i, j, dp);
			}
		}
		return dp[N][result];
	}

	private static void makeDP(int i, int j, long[][] dp) {

		int next = j + arr[i];
		if (canGo(next)) {
			dp[i][next] += dp[i - 1][j];
		}
		next = j - arr[i];
		if (canGo(next)) {
			dp[i][next] += dp[i - 1][j];
		}

	}

	private static boolean canGo(int sum) {
		return sum >= 0 && sum < 21;
	}

	private static int initInput() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		int result = -1;
		try {
			N = Integer.parseInt(br.readLine()) - 1;
			arr = new int[N + 1];
			str = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(str.nextToken());
			}
			result = Integer.parseInt(str.nextToken());
		} catch (NumberFormatException | IOException e) {
		}

		return result;
	}

}
