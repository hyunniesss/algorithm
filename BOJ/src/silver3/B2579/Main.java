package silver3.B2579;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author hyunhee
 * dp[n][0] : +1칸으로 온 경우
 * dp[n][1] : +2칸으로 온 경우
 * 1칸 전의 점수 (+2로 온 경우) + 현재 칸
 * 2칸 전의 점수(+1로 온 경우, +2 로 온 경우 중 큰 값) + 현재 칸  
 */

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] stairs = new int[N + 1];
		for (int n = 1; n <= N; n++) {
			stairs[n] = Integer.parseInt(br.readLine());
		}

		if (N == 1) {
			System.out.println(stairs[N]);
			return;
		}
		int[][] dp = new int[N + 2][2];
		dp[1][0] = stairs[1];
		dp[2][0] = stairs[1] + stairs[2];
		dp[1][1] = stairs[1];
		dp[2][1] = stairs[2];
		for (int n = 3; n <= N; n++) {
			dp[n][1] = Math.max(dp[n - 2][0], dp[n - 2][1]) + stairs[n];
			dp[n][0] = dp[n - 1][1] + stairs[n];
		}
		System.out.println(Math.max(dp[N][0], dp[N][1]));

	}

}
