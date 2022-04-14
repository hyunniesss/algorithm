package silver3;

import java.util.Scanner;

public class B2193_Main {

	public static void main(String[] args) {

		int N = initInput(); // N자리 이친수 개수
		long answer = getPinaryNumber(N);
		System.out.println(answer);
	}

	private static long getPinaryNumber(int n) {
		long[][] pNum = new long[n + 1][2];
		pNum[1][1] = 1;
		for (int i = 2; i <= n; i++) {
			pNum[i][0] = pNum[i - 1][0] + pNum[i - 1][1];
			pNum[i][1] = pNum[i - 1][0];
		}
		return getPinaryNumberCount(pNum[n]);

	}

	private static long getPinaryNumberCount(long[] arr) {
		return arr[0] + arr[1];
	}

	private static int initInput() {
		try (Scanner sc = new Scanner(System.in)) {
			return sc.nextInt();
		}
	}

}
