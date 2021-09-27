package bronze3;

import java.util.Scanner;

public class B10991_Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) { // 층 수 == 별 개수

			int j = N - i;
			while (j-- > 0) {
				sb.append(" ");
			}
			for (j = 0; j < i; j++) {
				sb.append("* ");
			}
			sb.append("\n");

		}

		System.out.println(sb.toString());

	}

}
