package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B9461_Main {

	static int T;
	static final int MAX = 101;

	public static void main(String[] args) {
		int[] input = initInput();
		long[] sequence = new long[MAX];
		Arrays.fill(sequence, -1);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			getOutput(findSequence(input[i], sequence), sb);
		}
		System.out.println(sb.toString());
	}

	private static void getOutput(long answer, StringBuilder sb) {
		sb.append(answer).append("\n");
	}

	private static long findSequence(int idx, long[] seq) {
		if (seq[idx] >= 0) {
			return seq[idx];
		}
		if (idx <= 1) {
			return seq[idx] = idx;
		}
		if (idx == 2) {
			return seq[idx] = 1;
		}
		return seq[idx] = findSequence(idx - 3, seq) + findSequence(idx - 2, seq);
	}

	private static int[] initInput() {
		int[] arr = null;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			T = Integer.parseInt(br.readLine());
			arr = new int[T];
			for (int i = 0; i < T; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
		} catch (NumberFormatException | IOException e) {
		}

		return arr;
	}

}
