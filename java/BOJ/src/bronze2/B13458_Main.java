package bronze2;

import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;

public class B13458_Main {
//	총감독관 최대 1명, 부감독관 n명
//	i번 시험장에 있는 응시자의 수는 Ai
//	총감독관을 배정하지 않을 때, 배정했을 때(어디에)
//	필요한 감독관 수 총 인원 최소 // BFS
	
	static int N;	// 시험장 수
	static int[] arr;	// 각 시험장 인원 수
	static int B, C;	// B= 총감독관, C = 부감독관
	static class Point {
		int x;	// 총감독관 수
		int y;	// 부감독관 수
	}
	public static void main(String[] args) {
		initInput();
	}
	private static void initInput() {
		
		
	}

}
