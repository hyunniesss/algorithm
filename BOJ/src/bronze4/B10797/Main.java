package bronze4.B10797;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int date = sc.nextInt(), answer = 0;
		for(int i=0;i<5;i++) {
			if(date==sc.nextInt()) {
				answer++;
			}
		}
		System.out.println(answer);
		sc.close();
		
	}

}
