package bronze4;

import java.util.Scanner;

public class B1008_Main {

	public static void main(String[] args) {
		// 입력
		double a = 0, b = 0;
		try (Scanner sc = new Scanner(System.in)) {
			a = sc.nextDouble();
			b = sc.nextDouble();
		}
		// 출력
		System.out.println(a / b);
	}

}
