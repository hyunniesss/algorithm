package bronze1;

import java.util.Scanner;

public class B2839_Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		while (N % 5 > 0) {
			N -= 3;
			if (N < 0) {
				cnt = -1;
				break;
			}
			cnt++;
		}
		System.out.println(cnt + N / 5);

	}

}
