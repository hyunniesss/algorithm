package silver3.B2579;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_fail {

	static int[] stairs;
	static int[][] dp;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		stairs = new int[N];
		dp = new int[N][2];
		for (int n = 0; n < N; n++) {
			stairs[n] = Integer.parseInt(br.readLine());
		} // end input

		dp[N - 1][0] = stairs[N - 1]; // +1로 갈 마지막 계단
		dp[N - 1][1] = stairs[N - 1]; // +2로 갈 마지막 계단
		for (int n = N - 3; n >= 0; n -= 2) {
			dp[n][1] = stairs[n] + dp[n + 2][1]; // -2하면서 계단 내려가기
		}
		int con = 2;
		for (int n = N - 2; n >= 0; n--, con++) {
			if (con < 3) { // -1, -1 이 아닐 때
				int oneStep = dp[n + 1][0] + stairs[n]; // -1로 온 경우
				if (n < N - 2) {
					int twoStep = dp[n + 2][1] + stairs[n]; // -2로 온경우
//					dp[n][0] = Math.max(twoStep, dp[n][1]);
//					dp[n][1] = Math.max(twoStep, dp[n][1]);
					dp[n][0] = twoStep;
				}
				if (oneStep > dp[n][0]) { // -1로 온 게 더 큰 값일 때
					dp[n][0] = oneStep;
				} else {
					con = 1; // -2로 오면 continuous +1 부터 시작
				}
			} else { // -1, -1로 오면 -2로 가는 경우만 확인
				dp[n][0] = Math.max(dp[n + 2][0] + stairs[n], dp[n][1]); // -2로만 왓을 경우랑 -1-1-2로 오는 경우 비교
				con = 1;
			}
		}
		if (N == 1) {
			System.out.println(dp[0][0]);
		} else {
			System.out.println(dp[0][0]);
		}

	}

}
