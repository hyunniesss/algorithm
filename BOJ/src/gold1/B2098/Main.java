package gold1.B2098;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp, map;
	static int V, all;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		V = Integer.parseInt(br.readLine());
		all = (1 << V) - 1;
		dp = new int[17][1 << 17];
		map = new int[V + 1][V + 1];

		for (int i = 1; i <= V; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= V; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
			}
		}

		System.out.println(dfs(1, 1));

	}

	static final int INF = 16000001;

	private static int dfs(int cur, int status) {

		if (status == all) { // 전부 방문했으면
			return map[cur][1];
		}
		if (dp[cur][status] != 0) {
			return dp[cur][status];
		}

		int temp = INF;

		for (int i = 1; i <= V; i++) {
			if ((status & (1 << (i - 1))) != 0 || map[cur][i] == 0) { // 이미 방문한 적이 있거나 가지 못하는 곳이면
				continue;
			}

			temp = Math.min(temp, map[cur][i] + dfs(i, (status | (1 << (i - 1)))));
		}

		return dp[cur][status] = temp;
	}

}
