package gold4.B2661;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author hyunhee N은 1 이상 80 이하
 *
 */

public class Main {

	static int N;
	static char[] number;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		number = new char[N];
		number[0] = '1';
		makeNumber(1);

		sc.close();

	}

	private static void makeNumber(int cnt) {
		if (cnt == N) {
			boolean flag = test();
			if (flag) {
				StringBuilder sb = new StringBuilder();
				for (char c : number) {
					sb.append(c);
				}
				System.out.println(sb);
				System.exit(0);
			}
			return;
		}
		for (int i = 1; i <= 3; i++) {
			if (number[cnt - 1] - '0' != i) {
				number[cnt] = (char) ('0' + i);
				makeNumber(cnt + 1);
			}
		}
	}

	private static boolean test() {
		boolean flag = true;
		for (int i = 0; i <= N/2; i++) {
			for (int j = i + 1; j < N; j++) {
				if (number[i] == number[j]) {
					flag = false;
					for (int k = 1; k < j - i; k++) {
						if (j + k >= N) {
							return true;
						}
						if (number[i + k] == number[j + k]) {
							flag = false;
						} else {
							flag = true;
							break;
						}
					}
					if (!flag)
						return flag;
				}
			}
		}
		return true;
	}

}
