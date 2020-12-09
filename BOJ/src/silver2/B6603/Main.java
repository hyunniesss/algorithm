package silver2.B6603;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int K;
	static int[] input;
	static boolean[] check;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		do {
			K = Integer.parseInt(str.nextToken());
			input = new int[K];
			check = new boolean[K];
			for (int k = 0; k < K; k++) {
				input[k] = Integer.parseInt(str.nextToken());
			}
			combi(0, 0, new int[6]);
			str = new StringTokenizer(br.readLine());
			System.out.println();
		} while (str.countTokens() > 1);

	}

	private static void combi(int cnt, int cur, int[] answer) {

		if (cnt == 6) {
			StringBuilder sb = new StringBuilder();
			for (int i : answer) {
				sb.append(i + " ");
			}
			System.out.println(sb);
			return;
		}

		for (int k = cur; k < K; k++) {
			if (!check[k]) {
				check[k] = true;
				answer[cnt] = input[k];
				combi(cnt + 1, k + 1, answer);
				check[k] = false;
			}
		}

	}

}
