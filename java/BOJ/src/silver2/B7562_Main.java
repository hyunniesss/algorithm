package silver2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7562_Main {

	static int N;
	static int eR, eC;
	static boolean[][] MAP;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {

			N = Integer.parseInt(br.readLine());
			MAP = new boolean[N][N];
			str = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(str.nextToken());
			int c = Integer.parseInt(str.nextToken());

			str = new StringTokenizer(br.readLine(), " ");
			eR = Integer.parseInt(str.nextToken());
			eC = Integer.parseInt(str.nextToken());

			MAP[r][c] = true;
			System.out.println(bfs(r, c));

		}
	}

	static int[][] dirs = { { -2, -1 }, { -1, -2 }, { 1, -2 }, { 2, -1 }, { 2, 1 }, { 1, 2 }, { -1, 2 }, { -2, 1 } };

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

	private static int bfs(int r, int c) {

		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(r, c, 0));

		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			if (cur.r == eR && cur.c == eC) {
				return cur.depth;
			}

			for (int d = 0; d < dirs.length; d++) {
				int nr = cur.r + dirs[d][0];
				int nc = cur.c + dirs[d][1];
				if (canGo(nr, nc)) {
					MAP[nr][nc] = true;
					queue.offer(new Point(nr, nc, cur.depth + 1));
				}
			}
		}

		return -1;
	}

	private static boolean canGo(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N && !MAP[r][c];
	}

}
