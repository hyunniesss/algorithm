package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1912_Main {
	
	static int[] arr;	// 입력받을 배열
	static int[] dp;	// 연속합을 저장할 배열
	static int N;
	
	public static void main(String[] args) {
		
		initInput();
		
		// 로직
		for(int i=0;i<N;i++) {
			int temp = 0, j = 0;
			while(i+j < N && dp[i+j] < temp + arr[i+j]) { // 이전에 저장해둔 연속합이 갱신될 동안
				temp += arr[i+j];
				dp[i+j] = temp;
				j++;
			}
		}
		Arrays.sort(dp);
		System.out.println(dp[N-1]);
		
	}

	private static void initInput() {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str  = null;
		
		try {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			dp = new int[N];
			Arrays.fill(dp, -1001);
			str = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(str.nextToken());
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		
	}

}
