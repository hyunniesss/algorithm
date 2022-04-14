package silver5;

import java.util.Arrays;
import java.util.Scanner;

public class B1037_Main {

	static int[] arr; // 약수배열

	public static void main(String[] args) {
		initInput();
		Arrays.sort(arr);
		int answer = arr[N - 1] + arr[N - 1]; // 큰 수의 배수로 구하기
		if (N == 2 && arr[0] == 1) {	// 이 경우 arr = {1, A} 이기 때문에 else문 연산 시 자기자신 나옴
			System.out.println(answer);
		} else {
			System.out.println(arr[0] * arr[N - 1]);
		}
	}

	static int N;

	private static void initInput() {
		try (Scanner sc = new Scanner(System.in)) {
			N = sc.nextInt();
			arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
		}
	}

}
