package d1.S1933;

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		sb.append(1).append(" ");
		int N = sc.nextInt();
		for(int n=2;n<=N/2;n++) {
			sb.append(N%n==0 ? n+" " : "");
		}
		sb.append(N);
		System.out.println(sb);
		sc.close();
	}

}
