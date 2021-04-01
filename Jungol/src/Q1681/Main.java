package Q1681;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static final int INF = Integer.MAX_VALUE;
	static int[][] adj;
	static boolean[] check;

	static int answer = INF;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine().trim());

		adj = new int[N][N];
		check = new boolean[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				adj[i][j] = Integer.parseInt(str.nextToken());
				if (adj[i][j] == 0) {
					adj[i][j] = INF;
				}
			}
		}

		dfs(0, 0, 0);

		System.out.println(answer);

	}

	private static void dfs(int cur, int cnt, int sum) {
		if (sum >= answer) {
			return;
		}
		if (cur == 0 && cnt == N) {
			answer = Math.min(sum, answer);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!check[i] && adj[cur][i] != INF) {
				check[i] = true;
				dfs(i, cnt + 1, sum + adj[cur][i]);
				check[i] = false;
			}
		}

	}

}
