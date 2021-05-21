package bronze4;

import java.util.Scanner;

public class B1712_Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		long c = sc.nextLong();
		if (b >= c) {
			System.out.println(-1);
		} else {

			long answer = a / (c - b);

			System.out.println(answer + 1);
		}

		sc.close();
	}

}
