package bronze1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11050_Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(str.nextToken());
		int K = Integer.parseInt(str.nextToken());
		System.out.println((factorial(N) / factorial(K)) / factorial(N - K));
	}

	private static int factorial(int n) {
		if (n == 1) {
			return 1;
		}
		if (n == 0) {
			return 1;
		}
		return n * factorial(n - 1);
	}

}
