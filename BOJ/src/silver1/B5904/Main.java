package silver1.B5904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int N;
	static int[] dp = new int[30];	// S[N]의 길이
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp[0] = 3;
		for(int i=1;i<30;i++) {
			dp[i] = 2*dp[i-1] + i+3;
		}
		
		System.out.println(dfs(N));
		
	}

	private static char dfs(int n) {
		// 기저조건 : 첫번째 두번째 세번째는 moo
		if(n==1) {
			return 'm';
		} else if(n==2 || n==3) {
			return 'o';
		}
		
		int i=0;
		while(dp[i]<n) {
			i++;
		}
		if(dp[i]==n) {
			return 'o';	// 마지막 자리
		} else if(n-dp[i-1]==1) {	// S[i-1]의 길이 + 1의 자리면 m
			return 'm';
		} else if(n-dp[i-1]<=i+3) {	// S[i-1]의 길이 +1부터 다음 i+3번째 짜리까지는 o
			return 'o';
		} 
		
		return dfs(n-dp[i-1]-(i+3));	// n번째가 오른쪽부분에 있을 경우를 위해 찾고자 하는 n에서 앞 부분 빼고 가운데 뺴고 앞부분이랑 똑같은 뒷부분
	}
	

}
