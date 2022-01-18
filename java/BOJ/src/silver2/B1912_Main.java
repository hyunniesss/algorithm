package silver2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1912_Main {

	static int N;

	public static void main(String[] args) {
		int[] arr = initInput();
		int answer = findMaxVal(arr);
		System.out.println(answer);
	}

	private static int findMaxVal(int[] arr) {
		int[] dp = new int[N + 1];
		int max = -1000;
		for (int i = 1; i <= N; i++) {
			dp[i] = Math.max(dp[i - 1] + arr[i - 1], arr[i - 1]);
			max = Math.max(dp[i], max);
		}
		return max;
	}

	private static int[] initInput() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		int[] arr = null;
		try {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			str = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(str.nextToken());
			}
		} catch (Exception e) {
		}

		return arr;
	}

}
