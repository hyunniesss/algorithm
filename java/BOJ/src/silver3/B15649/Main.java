package silver3.B15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, R;
	static int[] arr;
	static boolean[] check;

	public static void main(String[] args) {

		initGame();

		permutation(0);

	}

	private static void permutation(int cnt) {
		if (cnt == R) {
			print();
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (check[i]) {
				continue;
			}
			check[i] = true;
			arr[cnt] = i;
			permutation(cnt + 1);
			check[i] = false;
		}

	}

	private static void print() {

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < R; i++) {
			sb.append(arr[i]).append(" ");
		}
		System.out.println(sb.toString());

	}

	private static void initGame() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer str = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(str.nextToken());
			R = Integer.parseInt(str.nextToken());
			arr = new int[R];
			check = new boolean[N + 1];

		} catch (IOException e) {
		}

	}

}
