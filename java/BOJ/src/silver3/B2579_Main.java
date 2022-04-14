package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2579_Main {

	static int[] stairs;
	static int[][] dp;
	static int LEN;

	public static void main(String[] args) {
		initInput();
		for (int i = 3; i <= LEN; i++) {
			dp[i][0] = dp[i - 1][2] == 0 ? 0 : (dp[i - 1][2] + stairs[i]); // +1로 와야되니까 -2에서 와야돼..
			dp[i][1] = dp[i - 1][0] == 0 ? 0 : (dp[i - 1][0] + stairs[i]); // +1+1로 와야되니까 -1에서 와야돼
			int max = Math.max(dp[i - 2][0], Math.max(dp[i - 2][1], dp[i - 2][2]));
			dp[i][2] = max == 0 ? 0 : (max + stairs[i]); // +2로 와야되니까 -2 에서 가장 큰
		}

		System.out.println(Math.max(dp[LEN][0], Math.max(dp[LEN][1], dp[LEN][2])));
	}

	private static void initInput() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			LEN = Integer.parseInt(br.readLine());
			stairs = new int[LEN + 1];
			dp = new int[LEN + 2][3]; // +1, +1+1, 2
			for (int i = 1; i <= LEN; i++) {
				stairs[i] = Integer.parseInt(br.readLine());
			}
			dp[1][0] = stairs[1]; // +1로 출발
			dp[2][1] = dp[1][0] + stairs[2];
			dp[2][2] = stairs[2];
		} catch (NumberFormatException | IOException e) {
		}
	}

}
