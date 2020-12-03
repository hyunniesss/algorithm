package d1.S2070;

import java.util.Scanner;

public class Solution_Scanner {

	static int T;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			sb.append("#").append(tc).append(" ");
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(a<b)
				sb.append("<");
			else if(a==b)
				sb.append("=");
			else
				sb.append(">");
			
			sb.append("\n");
		}
		System.out.println(sb);
		
		sc.close();

	}

}
