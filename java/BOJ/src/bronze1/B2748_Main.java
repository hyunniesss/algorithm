package bronze1;

import java.util.Scanner;

public class B2748_Main {

	public static void main(String[] args) {
		int N = initInput();
		long answer = findFibo(N, new long[N + 1]);
		System.out.println(answer);
	}

	private static long findFibo(int N, long[] dp) {
		if (N <= 1) {
			return N;
		}
		if (dp[N] > 0) {
			return dp[N];
		}
		return dp[N] = findFibo(N - 1, dp) + findFibo(N - 2, dp);
	}

	private static int initInput() {
		try (Scanner sc = new Scanner(System.in)) {
			return sc.nextInt();
		}
	}

}
