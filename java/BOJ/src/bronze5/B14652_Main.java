package bronze5;

import java.util.Scanner;

public class B14652_Main {

	static int N, M, K;

	public static void main(String[] args) {

		initInput();
		System.out.println(K / M + " " + K % M);
	}

	private static void initInput() {
		try (Scanner sc = new Scanner(System.in)) {
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
		}
	}

}
