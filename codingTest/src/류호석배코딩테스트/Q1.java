package 류호석배코딩테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1 {

	static String base = "0123456789abcdefghijklmnopqrstuvwxyz";
	static final long INF = (long) Math.pow(2, 63);

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		char[] A = str.nextToken().toCharArray();
		char[] B = str.nextToken().toCharArray();

		int minA = 2;
		for (int i = 0; i < A.length; i++) {
			if (base.indexOf(A[i]) > minA) {
				minA = base.indexOf(A[i]);
			}
		}
		int minB = 2; // 최소 minB진법 이상이어야 계산할 수 있음
		for (int i = 0; i < B.length; i++) {
			if (base.indexOf(B[i]) > minB) {
				minB = base.indexOf(B[i]);
			}
		}

		minA++;
		minB++;

		long[] numberA = new long[base.length() + 1];
		long[] numberB = new long[base.length() + 1];

		long X = -1;
		int count = 0, a = 0, b = 0;

		// 이제 교환을 해보자
		for (int i = minA; i <= base.length(); i++) {
			long result = 0L;
			for (int j = 0; j < A.length; j++) {
				result *= i;
				result += base.indexOf(A[j]);
			}
			numberA[i] = result;
		}

		for (int i = minB; i <= base.length(); i++) {
			long result = 0L;
			for (int j = 0; j < B.length; j++) {
				result *= i;
				result += base.indexOf(B[j]);
			}
			if (result > 0) {
				numberB[i] = result;
			}

		}

		for (int i = minA; i <= base.length(); i++) {
			for (int j = minB; j <= base.length(); j++) {
				if (i == j) {
					continue;
				}
				if (numberA[i] == numberB[j] && numberA[i] < INF) {
					count++;
					if (count > 1) {
						System.out.println("Multiple");
						return;
					}
					X = numberA[i];
					a = i;
					b = j;
				}
			}
		}

		if (count == 1) {
			System.out.println(X + " " + a + " " + b);
		} else {
			System.out.println("Impossible");
		}

	}

}
