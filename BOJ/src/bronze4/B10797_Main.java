package bronze4;

import java.util.Scanner;

public class B10797_Main {
	
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
