package d1.S1938;

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		StringBuilder sb = new StringBuilder();
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		sb.append(a+b).append("\n");
		sb.append(a-b).append("\n");
		sb.append(a*b).append("\n");
		sb.append(a/b);
		System.out.println(sb);
		sc.close();
	}

}
