package gold5.B14500;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R, C;
	static int[][] MAP;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(str.nextToken());
		C = Integer.parseInt(str.nextToken());
		MAP = new int[R][C];

		for (int i = 0; i < R; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				MAP[i][j] = Integer.parseInt(str.nextToken());
			}
		}

		check = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {

				check[i][j] = true;

				dfs(i, j, 1, MAP[i][j]);

				dfsElse(i, j);
				check[i][j] = false;
			}
		}

		System.out.println(MAX);
	}

	static final int TETRO = 4;
	static boolean[][] check;

	private static void dfs(int r, int c, int depth, int sum) {

		if (depth == TETRO) {
			MAX = Math.max(MAX, sum);
			return;
		}

		int nr, nc;
		for (int d = 0; d < dirs.length; d++) {
			nr = r + dirs[d][0];
			nc = c + dirs[d][1];
			if (isIn(nr, nc) && !check[nr][nc]) {
				check[nr][nc] = true;
				dfs(nr, nc, depth + 1, sum + MAP[nr][nc]);
				check[nr][nc] = false;
			}
		}

	}

	private static void dfsElse(int r, int c) {

		if (isIn(r - 1, c + 2)) {
			MAX = Math.max(MAX, MAP[r][c] + MAP[r][c + 1] + MAP[r][c + 2] + MAP[r - 1][c + 1]);
		}
		if (isIn(r + 1, c + 2)) {
			MAX = Math.max(MAX, MAP[r][c] + MAP[r][c + 1] + MAP[r][c + 2] + MAP[r + 1][c + 1]);
		}
		if (isIn(r + 2, c + 1)) {
			MAX = Math.max(MAX, MAP[r][c] + MAP[r + 1][c] + MAP[r + 2][c] + MAP[r + 1][c + 1]);
		}
		if (isIn(r + 2, c - 1)) {
			MAX = Math.max(MAX, MAP[r][c] + MAP[r + 1][c] + MAP[r + 1][c - 1] + MAP[r + 2][c]);
		}

	}

	static class Point {
		int r, c;
		int cnt;
		int sum;
		boolean[][] check = new boolean[R][C];

		public Point(int r, int c, int cnt, int sum, boolean[][] check) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.sum = sum;

			for (int i = 0; i < R; i++) {
				this.check[i] = check[i].clone();
			}
		}

	}

	static int MAX = -1;

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

}
