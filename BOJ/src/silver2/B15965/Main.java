package silver2.B15965;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static List<Integer> isPrime = new ArrayList<>();
	static boolean[] check = new boolean[100000000];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		for (int i = 2; i <= check.length / 2; i++) {
			if (!check[i]) {
				isPrime.add(i);
				if (isPrime.size() == K) {
					break;
				}
				for (int j = i + i; j < check.length; j += i) {
					check[j] = true;
				}
			}
		}
		System.out.println(isPrime.get(K - 1));

	}

}
