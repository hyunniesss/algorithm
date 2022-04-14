package bronze4;

import java.util.Arrays;
import java.util.Scanner;

public class B2480_Main {
	
//	1. 같은 눈이 3개가 나오면 10,000원+(같은 눈)×1,000원의 상금을 받게 된다. 
//	2. 같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금을 받게 된다. 
//	3. 모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)×100원의 상금을 받게 된다.  
	
	static final int LEN = 3;
	static final int MAN = 10000, CHEON = 1000, BAEK = 100;
	
	public static void main(String[] args) {
		int[] arr = new int[LEN];
		try(Scanner sc = new Scanner(System.in)) {
			for(int i=0;i<LEN;i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
		}
		int answer = 0;
		if(arr[0] == arr[1] && arr[1] == arr[2]) {
			answer = MAN + (arr[0] * CHEON);
		} else if(arr[0] != arr[1] && arr[1] != arr[2]) {
			answer = arr[2] * BAEK;
		} else {
			answer = CHEON + (BAEK * arr[0]);
			if(arr[0] == arr[1]) {
				answer = CHEON + (BAEK * arr[0]);
			} else if(arr[1] == arr[2]) {
				answer = CHEON + (BAEK * arr[1]);
			}
		}
		
		System.out.println(answer);
	}

}
