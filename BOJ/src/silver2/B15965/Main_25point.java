package silver2.B15965;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author hyunhee 자연수 K가 주어진다.(1 ≤ K ≤ 500,000)
 * 
 */
public class Main_25point {

	static int K;
	static boolean[] isPrime = new boolean[500001];

	public static void main(String[] args) {

		for (int i = 2; i < isPrime.length / 2; i++) {
			if (!isPrime[i]) {
				for (int j = i + i; j < isPrime.length; j += i) {
					isPrime[j] = true;
				}
			}
		}

		Scanner sc = new Scanner(System.in);

		K = sc.nextInt();
		int cnt = 0;
		int idx = 1;
		while (cnt < K) {
			idx++;
			if (!isPrime[idx]) {
				cnt++;
			}
		}
		
		System.out.println(idx);

	}

}
