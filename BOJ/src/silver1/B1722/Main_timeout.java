package silver1.B1722;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_timeout {

	static int N;
	static int K;
	static int[] numbers;
	static int[] input;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = i + 1;
		}
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		switch (str.nextToken()) {
		case "1":
			K = Integer.parseInt(str.nextToken());
			do {
				K--;
			} while (K > 0 && nextPermutation());
			for (int i : numbers) {
				System.out.print(i + " ");
			}
			break;
		case "2":
			input = new int[N];
			for (int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(str.nextToken());
			}
			do {
				K++;
			} while (check() && nextPermutation());
			System.out.println(K);
		}
	}

	private static boolean check() {
		for (int i = 0; i < N; i++) {
			if (input[i] != numbers[i]) {
				return true;
			}
		}
		return false;
	}

	private static boolean nextPermutation() {
		// STEP1. 꼭지점 찾기
		int i = N - 1;
		while (numbers[i - 1] >= numbers[i]) {
			i--;
		}
		if (i == 0) {
			return false;
		}

		// STEP2. 교환할 큰 값 찾기
		int j = N - 1;
		while (numbers[i - 1] >= numbers[j]) {
			j--;
		}

		// STEP3. i-1이랑 j 교환
		int temp = numbers[i - 1];
		numbers[i - 1] = numbers[j];
		numbers[j] = temp;

		// STEP4. i부터 swap
		int k = N - 1;
		while (i < k) {
			temp = numbers[i];
			numbers[i] = numbers[k];
			numbers[k] = temp;
			i++;
			k--;
		}
		return true;
	}

}
