package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B9252_Main {

	static char[] A, B;

	public static void main(String[] args) {
		initInput();

		String answer = solve();
		System.out.println(answer.length());
		if(answer.length()>0) {
			System.out.println(answer);
		}
	}

	private static String solve() {
		
		String answer = "";
		String[][] dp = new String[A.length+1][B.length+1];
		for(int i=0;i<A.length+1;i++) {
		Arrays.fill(dp[i], "");
		}
		for(int i=1;i<A.length+1;i++) {
			for(int j=1;j<B.length+1;j++) {
				if(A[i-1] == B[j-1]) {
					dp[i][j] = dp[i-1][j-1] + A[i-1];
				} else {
					dp[i][j] = dp[i-1][j].length() > dp[i][j-1].length() ? dp[i-1][j] : dp[i][j-1];
				}
				answer = answer.length() > dp[i][j].length() ? answer : dp[i][j];
			}
		}
		
		return answer;
	}

	private static void initInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			A = br.readLine().toCharArray();
			B = br.readLine().toCharArray();
		} catch (IOException e) {
		}
	}

}
