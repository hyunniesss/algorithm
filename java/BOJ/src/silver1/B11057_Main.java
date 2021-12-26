package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B11057_Main {
	
	static final int MOD = 10007;
	
	public static void main(String[] args) {
		int N = 0;
		// 입력
		try {
			N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		} catch(IOException | NumberFormatException e) {}
		
		// 로직
		int[][] dp = new int[N+1][10];	//n자리의 0~9까지 끝나는 수의 개수
		Arrays.fill(dp[1], 1);
		for(int n=2;n<=N;n++) {
			for(int i=0;i<10;i++) {
				for(int j=0;j<=i;j++) {
					dp[n][i] = (dp[n][i]+dp[n-1][j])%MOD;
				}
			}
		}
		int answer = 0;
		for(int i : dp[N]) {
			answer = (answer+i)%MOD;
		}
		System.out.println(answer);
	}

}
