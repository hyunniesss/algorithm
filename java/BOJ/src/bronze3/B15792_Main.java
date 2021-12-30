package bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15792_Main {

	public static void main(String[] args) {
		// 입력
		int[] input = initInput();
		// 나눗셈을 구현
		String answer = modulus(input);
		System.out.println(answer);
	}

	private static String modulus(int[] input) {
		int cnt = 0;
		StringBuilder answer = new StringBuilder(String.valueOf(input[0] / input[1])).append('.');
		while (cnt++ <= 2000 && input[0] % input[1] != 0) {
			input[0] = (input[0] % input[1]) * 10;
			answer.append(input[0] / input[1]);
//			input[0] = (input[0] % input[1]) * 10;
		}

		return answer.toString();
	}

	private static int[] initInput() {

		int[] input = new int[2];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		try {
			str = new StringTokenizer(br.readLine(), " ");
			input[0] = Integer.parseInt(str.nextToken()); // a
			input[1] = Integer.parseInt(str.nextToken()); // b
		} catch (IOException e) {
		}
		return input;
	}

}
