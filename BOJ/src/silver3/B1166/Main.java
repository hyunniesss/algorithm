package silver3.B1166;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// N L W H
		int N = sc.nextInt();
		int L = sc.nextInt();
		int W = sc.nextInt();
		int H = sc.nextInt();

		double left = 0, right = Math.min(L, Math.min(W, H)), mid = -1;
		for (int i = 0; i < 10000; i++) {
			mid = (left + right) / 2;
			if ((L / mid) * (W / mid) * (H / mid) >= N) {
				left = mid;
			} else {
				right = mid;
			}
			if (left == right) {
				break;
			}
		}

		System.out.printf("%.9f", mid);

	}

}
