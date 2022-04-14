package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1890_Main {

	static int N;
	static int[][] map;

	public static void main(String[] args) {
		initInput();

		long answer = solve();
		System.out.println(answer);
	}

	private static long solve() {
		long[][] dp = new long[N][N];
		dp[0][0] = 1L;
		int nr, nc;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (dp[r][c] == 0 || map[r][c] == 0) {
					continue;
				}
				nr = r + map[r][c];
				nc = c + map[r][c];
				if (isIn(nr)) {
					dp[nr][c] += dp[r][c];
				}
				if (isIn(nc)) {
					dp[r][nc] += dp[r][c];
				}
			}
		}

		return dp[N - 1][N - 1];
	}

	private static boolean isIn(int r) {
		return r >= 0 && r < N;
	}

	private static void initInput() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;

		try {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				str = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(str.nextToken());
				}
			}
		} catch (NumberFormatException | IOException e) {
		}

	}

}
