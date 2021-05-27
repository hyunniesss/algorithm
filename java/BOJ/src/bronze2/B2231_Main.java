package bronze2;

import java.util.Scanner;

public class B2231_Main {

	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			int temp = i;
			int calc = temp;
			while (temp != 0) {
				calc += temp % 10;
				temp /= 10;
			}
			if (calc == N) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(0);
		sc.close();

	}

}