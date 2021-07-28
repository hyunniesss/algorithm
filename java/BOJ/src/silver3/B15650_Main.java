package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15650_Main {

	static int[] arr;
	static StringBuilder output;

	public static void main(String[] args) {

		makeInput();

		makeCombi(1, 0);
		System.out.println(output.toString());

	}

	private static void makeCombi(int cur, int cnt) {
		if (cnt == R) {
			makeOutput();
			return;
		}

		for (int i = cur; i <= N; i++) {
			arr[cnt] = i;
			makeCombi(i + 1, cnt + 1);
		}
	}

	private static void makeOutput() {

		for (int i = 0; i < R; i++) {
			output.append(arr[i]).append(" ");
		}
		output.append("\n");

	}

	static int N, R;

	private static void makeInput() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		output = new StringBuilder();
		try {
			StringTokenizer str = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(str.nextToken());
			R = Integer.parseInt(str.nextToken());
		} catch (IOException e) {
		}
		arr = new int[R];

	}

}
