package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GCD {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(str.nextToken());
		int B = Integer.parseInt(str.nextToken());

		int result1 = gcd1(A, B, 1);
		int result2 = gcd2(Math.max(A, B), Math.min(A, B));
		System.out.println(result1 + " " + result2);
	}

	private static int gcd2(int a, int b) {
		if (b == 0) {
			return a;
		}

		// 항상 a>b인 상태
		return gcd2(Math.max(a % b, b), Math.min(a % b, b));
	}

	private static int gcd1(int a, int b, int result) {
		if (a == b) {
			return result;
		}

		for (int i = 2; i <= Math.min(a, b); i++) {
			if (a % i == 0 && b % i == 0) {
				return gcd1(a / i, b / i, result * i);
			}
		}

		return result;
	}

}
