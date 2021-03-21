package bronze3;

import java.util.Scanner;

public class B2747_Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long result = 0L;
		long a = 1L, b = 1L;
		if (N == 1 || N == 2) {
			result++;
		} else if (N > 2) {
			for (int n = 3; n <= N; n++) {
				result = a + b;
				a = b;
				b = result;
			}
		}
		
		System.out.println(result);

	}

}
