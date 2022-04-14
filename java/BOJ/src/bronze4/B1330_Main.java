package bronze4;

import java.util.Scanner;

public class B1330_Main {

	public static void main(String[] args) {
		// 입력
		int a = 0, b = 0;
		try (Scanner sc = new Scanner(System.in)) {
			a = sc.nextInt();
			b = sc.nextInt();
		}

		System.out.println(a > b ? ">" : (a == b ? "==" : "<"));
	}

}
