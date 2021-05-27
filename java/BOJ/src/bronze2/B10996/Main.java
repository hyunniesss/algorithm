package bronze2.B10996;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int i = sc.nextInt();

		StringBuilder a = new StringBuilder();
		StringBuilder b = new StringBuilder();
		
		for(int j=0;j<i;j++) {
			if(j%2==0) {
				a.append("* ");
			} else {
				b.append(" *");
			}
		}
		for(int j=0;j<i;j++) {
			System.out.println(a.toString());
			System.out.println(b.toString());
		}

		sc.close();

	}

}
