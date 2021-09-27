package bronze3.B16917;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int X = sc.nextInt(); // 양념
		int Y = sc.nextInt(); // 후라이드

		int answer = 0;
		int min = Math.min(X, Y);

		if (A + B < C * 2) {
			answer += (A * min + B * min);
		} else {
			answer += (C * 2 * min);
		}
		
		if(X<Y) {
			min = Y-X;
			
		} else if(X>Y) {
			
		}

	}

}
