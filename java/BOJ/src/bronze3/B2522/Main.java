package bronze3.B2522;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
//		1 ~ N번째줄
		for(int i=1;i<=N;i++) {	// 별 갯수
			for(int j=N-i;j>0;j--) {	// 빈칸 찍기
				sb.append(" ");
			}
			for(int j=0;j<i;j++) {	// 별 찍기
				sb.append("*");
			}
			sb.append("\n");
		}
//		N ~ 2N-1 번째 줄
		for(int i=N-1;i>0;i--) {	// 별 갯수
			for(int j=N-i;j>0;j--) {
				sb.append(" ");
			}
			for(int j=0;j<i;j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
		sc.close();
		
	}

}
