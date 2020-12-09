package silver5.B2609;

import java.util.Scanner;

public class Main {

	/**
	 * @author hyunhee 두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력
	 */

	static int A, B;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		A = sc.nextInt();
		B = sc.nextInt();
		int gcd = 1;

		for (int i = 2; i <= Math.max(A, B); i++) {
			if (A % i == 0 && B % i == 0) {
				gcd *= i;
				A /= i;
				B /= i;
				i = 1;
			}
		}
		System.out.println(gcd+"\n"+gcd*A*B);
		sc.close();

	}
}
