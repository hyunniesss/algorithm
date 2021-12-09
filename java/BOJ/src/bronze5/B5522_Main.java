package bronze5;

import java.util.Scanner;
import java.math.BigInteger;

public class B5522_Main {

	public static void main(String[] args) {

		BigInteger answer = new BigInteger("0");
		try (Scanner sc = new Scanner(System.in)) {
			for (int i = 0; i < 5; i++) {
				BigInteger a = new BigInteger(sc.nextLine());
				answer = answer.add(a);
			}
		}
		System.out.println(answer);

	}

}