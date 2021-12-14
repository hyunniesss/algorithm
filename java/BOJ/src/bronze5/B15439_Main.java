package bronze5;

import java.util.Scanner;

public class B15439_Main {
	
	// 1 ~ N 까지 nC1 * nC1 할 껀데 앞에 고른 거랑 다른 수여야 됨
	// 상의 하의 다름 -> 순열
	
	static int N;
	
	public static void main(String[] args) {
		
		initInput();
		
//		int cnt = 0;
//		for(int i=1;i<=N;i++) {
//			for(int j=1;j<=N;j++) {
//				if(i==j) {
//					continue;
//				}
//				cnt++;
//			}
//		}
//		System.out.println(cnt);
		System.out.println(N*(N-1));
		
	}


	private static void initInput() {
		
		try(Scanner sc = new Scanner(System.in)){
			N = sc.nextInt();
		}
		
	}

}
