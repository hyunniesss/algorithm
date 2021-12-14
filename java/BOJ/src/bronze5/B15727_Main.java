package bronze5;

import java.util.Scanner;

public class B15727_Main {

	public static void main(String[] args) {
		// 1분에 4의 거리 이동 할 수 있음
		// 거리 L
		int L = 0;
		try (Scanner sc = new Scanner(System.in)) {
			L = sc.nextInt();
		}
		System.out.println(L / 5 + (L % 5 == 0 ? 0 : 1));
	}

}
