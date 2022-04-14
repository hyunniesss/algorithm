package GoodBye2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
	static final int MAX = 501;
	static boolean[] isPrime = new boolean[MAX];

	public static void main(String[] args) throws NumberFormatException, IOException {

		makePrime();
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int a = 2, b = 3, temp = 6; // 가장 작은 소수
		while (temp <= N) {
			a = b;
			b = b+1;
			while(b < MAX && isPrime[b]) {
				b++;
			}
			if(a==b) {
				break;
			}
			temp = a * b;
		}
		System.out.println(temp);

	}

	private static void makePrime() {

		isPrime[0] = isPrime[1] = true;
		for (int i = 2; i < MAX / 2; i++) {
			if (isPrime[i]) {
				continue;
			}
			for (int j = i + i; j < MAX; j += i) {
				isPrime[j] = true;
			}
		}

	}

}
