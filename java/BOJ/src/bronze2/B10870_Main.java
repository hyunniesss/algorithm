package bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10870_Main {

	static int N, dp[];

	public static void main(String[] args) {
		initInput();
		int fibonacci = makeFibonacci(N);
		System.out.println(fibonacci);
	}

	private static int makeFibonacci(int n) {
		if (n <= 1) {
			return dp[n] = n;
		}
		if (dp[n] != 0) {
			return dp[n];
		}
		return dp[n] = makeFibonacci(n - 1) + makeFibonacci(n - 2);
	}

	private static void initInput() {

		try {
			N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
			dp = new int[21];
		} catch (NumberFormatException | IOException e) {
		}

	}

}
