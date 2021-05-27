package d1.S2019;

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		for(int n=0;n<=N;n++) {
			sb.append((int)Math.pow(2, n)).append(" ");
		}
		System.out.println(sb.toString().trim());
		
		sc.close();
	}

}
