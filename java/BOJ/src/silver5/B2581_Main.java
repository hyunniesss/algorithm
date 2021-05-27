package silver5;

import java.util.Scanner;

public class B2581_Main {

	static final int INF = -1;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();

		boolean[] isPrime = new boolean[N + 1];
		makePrime(N, isPrime);
		int min = INF;
		int sum = 0;
		for (int i = M; i <= N; i++) {
			if (!isPrime[i]) {
				if (min == INF) {
					min = i;
				}
				sum += i;
			}
		}
		if (sum > 0) {
			System.out.println(sum);
			System.out.println(min);
		} else {
			System.out.println(INF);
		}
		
		sc.close();

	}

	private static void makePrime(int N, boolean[] isPrime) {
		isPrime[0] = true;
		isPrime[1] = true;
		for (int i = 2; i <= Math.sqrt(N + 1); i++) {
			if (!isPrime[i]) {
				for (int j = i + i; j <= N; j += i) {
					isPrime[j] = true;
				}
			}
		}
	}

}
