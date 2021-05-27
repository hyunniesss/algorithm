package silver3.B2579;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * @author hyunhee 1. 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음
 *         계단이나, 다음 다음 계단으로 오를 수 있다. 2. 연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에
 *         포함되지 않는다. 3. 마지막 도착 계단은 반드시 밟아야 한다. <입력> 1. 계단의 개수 ( 300이하의 자연수 ) 2.
 *         각 계단에 쓰여 있는 점수 ( 10,000이하의 자연수 )
 */

public class Main_bottomUp_fail {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] stairs = new int[N];
		int[][] dp = new int[N][2];
		for (int n = 0; n < N; n++) {
			stairs[n] = Integer.parseInt(br.readLine());
			if (n % 2 == 1) {
				if (n - 2 >= 0) {
					dp[n][1] = dp[n - 2][1] + stairs[n];
				} else {
					dp[n][1] = stairs[n];
				}
			}
		}
		int con = 2;
		if(N==1) {
			System.out.println(stairs[0]);
			return;
		}
		
		dp[0][0] = stairs[0];
		dp[1][0] = stairs[0] + stairs[1];

		for (int n = 2; n < N; n++) {
			if (con < 2) {
				dp[n][0] = Math.max(dp[n - 1][0] + stairs[n], dp[n - 2][1] + stairs[n]);
				dp[n][0] = Math.max(dp[n - 2][0] + stairs[n], dp[n][0]);
				if (dp[n][0] < dp[n - 2][0] + stairs[n]) {
					dp[n][0] = dp[n - 2][0] + stairs[n];
					con = 1;
				} else {
					con++;
				}
			} else {
				dp[n][0] = Math.max(dp[n - 2][1], dp[n - 2][0]) + stairs[n];
				con = 1;
			}
		}

		System.out.println(dp[N - 1][0]);

	}

}
