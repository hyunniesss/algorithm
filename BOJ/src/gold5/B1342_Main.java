package gold5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1342_Main {

	static char[] input;
	static int len;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine().toCharArray();
		len = input.length;

		int result = 0;
		if (len == 1) {
			System.out.println(1);
			return;
		} else if (len == 2) {
			if (input[0] == input[1]) {
				System.out.println(1);
			} else {
				System.out.println(2);
			}
			return;
		}

		Arrays.sort(input);
		do {
			if (check()) {
				result++;
			}
		} while (nextPermution());

		System.out.println(result);

	}

	private static boolean check() {

		for (int i = 0; i < len - 1; i++) {
			if (input[i] == input[i + 1]) {
				return false;
			}
		}
		return true;

	}

	private static boolean nextPermution() {
		// STEP1. 꼭지점 찾기
		int i = len - 1;
		while (i > 0 && input[i - 1] >= input[i]) {
			--i;
		}
		if (i == 0) {
			return false;
		}

		// STEP2. 교환할 j지점 찾기
		int j = len - 1;
		while (input[i - 1] >= input[j]) {
			--j;
		}

		// STEP3. i-1이랑 j 교환
		char temp = input[i - 1];
		input[i - 1] = input[j];
		input[j] = temp;

		// STEP4. i~len-1까지 swap
		int k = len - 1;
		while (i < k) {
			temp = input[i];
			input[i] = input[k];
			input[k] = temp;
			++i;
			--k;
		}
		return true;
	}

}
