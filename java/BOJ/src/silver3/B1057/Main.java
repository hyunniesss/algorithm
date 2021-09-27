package silver3.B1057;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();

		boolean[] check = new boolean[N + 1];
		int count = N;
		int round = 0;

		while (count > 1) {
			round++;

			for (int i = 1; i < N; i++) {
				if (!check[i]) {	// 왼쪽놈
					int j = i + 1;	// 오른쪽 놈
					for (; j <= N; j++) {
						if (!check[j]) {
							break;
						}
					}
					if ((i == a && j == b) || (i == b && j == a)) {
						System.out.println(round);
						return;
					}
					
					if (j > N) {
						continue;
					}
					
					if (i == a || i == b) {
						check[j] = true;
					} else if (j == a || j == b) {
						check[i] = true;
					} else {
						check[i] = true;
					}

					count--;
					i = j;
				}
			}
		}

		System.out.println(-1);

	}

}
