package d1.S2029;

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			sb.append("#").append(t).append(" ");
			int a = sc.nextInt();
			int b = sc.nextInt();
			sb.append(a/b).append(" ").append(a%b);
			sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}

}
