package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15988_Main {

	static int T;
	static int[] arr, input_N;
	static final int MAX = 1000001, MOD = 1000000009;

	public static void main(String[] args) {
		initInput();
		StringBuilder sb = new StringBuilder();
		int max = 3;
		for (int i = 0; i < T; i++) {
			if (input_N[i] > max) {
				makeNumber(max+1, input_N[i]);
				max = input_N[i];
			}
			sb.append(arr[input_N[i]]).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void makeNumber(int start, int end) {
		if(start > end) {
			return;
		}
		for(int i=1;i<=3;i++) {
			arr[start] += arr[start-i];
			arr[start] %= MOD;
		}
		
		makeNumber(start+1, end);
	}

	private static void initInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			T = Integer.parseInt(br.readLine());
			input_N = new int[T];
			for (int t = 0; t < T; t++) {
				input_N[t] = Integer.parseInt(br.readLine());
			}
		} catch (NumberFormatException | IOException e) {
		}
		arr = new int[MAX];
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;

	}

}
