package silver3.B2579;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_timeout {

	static int answer = -1;
	static int[] stairs;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		stairs = new int[N];
		for (int i = 0; i < N; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		dfs(N - 1, 0, 0);
		System.out.println(answer);
	}

	private static void dfs(int cur, int sum, int cont) {
		sum += stairs[cur];
		if (cur == 0) {
			answer = Math.max(sum, answer);
			return;
		}

		if (cont < 1 && cur > 0) {
			dfs(cur - 1, sum, cont + 1);
		}
		if (cur > 1) {
			dfs(cur - 2, sum, 0);
		}

	}

}
