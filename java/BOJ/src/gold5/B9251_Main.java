package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9251_Main {
	
	static char[] A, B;
	
	public static void main(String[] args) {
		// 입력
		initInput();
		
		// 로직
		int answer = solve();
		System.out.println(answer);
	}
	
	private static int solve() {
		int[][] dp = new int[A.length+1][B.length+1];
		int max = -1;
		for(int i=1;i<A.length+1;i++) {
			for(int j=1;j<B.length+1;j++) {
				if(A[i-1]==B[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = dp[i][j-1] > dp[i-1][j] ? dp[i][j-1] : dp[i-1][j];
				}
				max = dp[i][j] > max ? dp[i][j] : max;
			}
		}
		return max;
	}

	private static void initInput() {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			A = br.readLine().toCharArray();
			B = br.readLine().toCharArray();
		} catch (IOException e) {}
		
	}

}
