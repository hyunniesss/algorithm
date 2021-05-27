package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2589_Main {

	static int R, C;
	static char[][] MAP;
	static boolean[][] check;

	public static void main(String[] args) {

		initMap();
		int MAX = -1;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (MAP[i][j] == 'L') {
					MAX = Integer.max(MAX, bfs(i, j));
				}
			}
		}

		System.out.println(MAX);

	}

	static class Point {
		int r;
		int c;
		int depth;

		public Point(int r, int c, int depth) {
			this.r = r;
			this.c = c;
			this.depth = depth;
		}

	}

	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	private static int bfs(int i, int j) {

		int answer = 0;

		Queue<Point> queue = new LinkedList<>();
		for (int k = 0; k < R; k++) {
			Arrays.fill(check[k], false);
		}

		check[i][j] = true;
		queue.offer(new Point(i, j, 0));

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			answer = p.depth;
			for (int d = 0; d < dirs.length; d++) {
				int nr = p.r + dirs[d][0];
				int nc = p.c + dirs[d][1];
				if (canGo(nr, nc)) {
					check[nr][nc] = true;
					queue.offer(new Point(nr, nc, p.depth + 1));
				}
			}

		}

		return answer;
	}

	private static boolean canGo(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C && !check[r][c] && MAP[r][c] == 'L';
	}

	private static void initMap() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer str = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(str.nextToken());
			C = Integer.parseInt(str.nextToken());

			MAP = new char[R][C];
			check = new boolean[R][C];

			for (int i = 0; i < R; i++) {
				MAP[i] = br.readLine().toCharArray();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
