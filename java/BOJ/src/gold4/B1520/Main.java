package gold4.B1520;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int R, C;
	static int[][] map;
	static int[][] dp;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(str.nextToken());
		C = Integer.parseInt(str.nextToken());

		map = new int[R][C];
		dp = new int[R][C];
		for (int i = 0; i < R; i++) {
			Arrays.fill(dp[i], -1);
		}
		for (int r = 0; r < R; r++) {
			str = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(str.nextToken());
			}
		}

		System.out.println(dfs(0, 0));

	}

	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	private static int dfs(int r, int c) {

		if (r == R - 1 && c == C - 1) {
			return 1;
		}

		if (dp[r][c] != -1) {
			return dp[r][c];
		}

		int nr, nc;

		dp[r][c] = 0;

		for (int d = 0; d < dirs.length; d++) {
			nr = r + dirs[d][0];
			nc = c + dirs[d][1];
			if (canGo(r, c, nr, nc)) {
				dp[r][c] += dfs(nr, nc);
			}
		}
		return dp[r][c];
	}

	private static boolean canGo(int r, int c, int nr, int nc) {
		return nr >= 0 && nr < R && nc >= 0 && nc < C && map[r][c] > map[nr][nc];
	}

}
