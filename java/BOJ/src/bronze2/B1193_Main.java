package bronze2;

import java.util.Scanner;

public class B1193_Main {

	static int up, down, X;

	public static void main(String[] args) {

		up = 1;
		down = 1;

		Scanner sc = new Scanner(System.in);
		X = sc.nextInt();
		boolean flag = false;
		while (true) {
			if (X == 1) {
				break;
			}

			if (first()) {
				break;
			}
			if (second()) {
				break;
			}
			if (third()) {
				break;
			}
			if (forth()) {
				break;
			}
		}

		System.out.println(up + "/" + down);

	}

	private static boolean forth() {
		while (up > 1) {
			up--;
			down++;
			X--;
			if (X == 1) {
				return true;
			}
		}
		return false;
	}

	private static boolean third() {
		up++;
		X--;
		return X == 1;
	}

	private static boolean second() {

		while (down > 1) {
			up++;
			down--;
			X--;
			if (X == 1) {
				return true;
			}
		}

		return false;
	}

	private static boolean first() {
		down++;
		X--;
		return X == 1;
	}

}
