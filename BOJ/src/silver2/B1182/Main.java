package silver2.B1182;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, S, answer, R;
	static int[] input;
	static boolean[] check;
	static int[] temp;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(str.nextToken());
		S = Integer.parseInt(str.nextToken());
		input = new int[N];
		str = new StringTokenizer(br.readLine(), " ");
		for (int n = 0; n < N; n++) {
			input[n] = Integer.parseInt(str.nextToken());
		} // end input

		for (int n = 1; n <= N; n++) {
			R = n;
			check = new boolean[N];
			temp = new int[n];
			combi(0, 0);
		}
		System.out.println(answer);

	}

	private static void combi(int cur, int cnt) {
		if (cnt == R) {
			int sum = 0;
			for (int i : temp) {
				sum += i;
			}
			if (sum == S) {
				answer++;
			}
			return;
		}

		for (int i = cur; i < N; i++) {
			if (!check[i]) {
				check[i] = true;
				temp[cnt] = input[i];
				combi(i + 1, cnt + 1);
				check[i] = false;
			}
		}

	}

}
