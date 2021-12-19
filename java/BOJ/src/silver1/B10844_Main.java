package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B10844_Main {
	
	static int N;
	static final int MAX = 101, MOD = 1000000000;
	static int[][] dp = new int[MAX][10];
	
	public static void main(String[] args) {
		
		// 1자리 수는 전부 1개씩
		Arrays.fill(dp[1], 1);
		dp[1][0] = 0;
		initInput();
		for(int i=2;i<=N;i++) {
			for(int j=1;j<9;j++) {
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%MOD;
			}
			dp[i][0] = dp[i-1][1];
			dp[i][9] = dp[i-1][8];
		}
		int sum = 0;
		for(int i=0;i<10;i++) {
			sum += dp[N][i];
			sum%=MOD;
		}
		System.out.println(sum);
	}

	private static void initInput() {
		try {
			N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		} catch (NumberFormatException | IOException e) {
		}
	}

}
