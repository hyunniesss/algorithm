package d1.S2046;

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		while(N-->0)
			sb.append("#");
		System.out.println(sb);
		sc.close();
	}

}
