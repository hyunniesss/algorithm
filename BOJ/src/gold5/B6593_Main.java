package gold5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B6593_Main {

	static final String wrong = "Trapped!\n";
	static final String[] success = { "Escaped in ", " minute(s).\n" };
	static int L, R, C;
	static char[][][] MAP;
	static int[][] dirs = { { -1, 0, 0 }, { 1, 0, 0 }, { 0, -1, 0 }, { 0, 1, 0 }, { 0, 0, -1 }, { 0, 0, 1 } };
	static Queue<Point> queue = new LinkedList<>();

	static class Point {
		int l;
		int r;
		int c;
		int depth;

		public Point(int l, int r, int c, int depth) {
			this.l = l;
			this.r = r;
			this.c = c;
			this.depth = depth;
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		String input = null;
		StringBuilder sb = new StringBuilder();
		while (!"0 0 0".equals(input = br.readLine())) {
			str = new StringTokenizer(input);
			L = Integer.parseInt(str.nextToken());
			R = Integer.parseInt(str.nextToken());
			C = Integer.parseInt(str.nextToken());

			MAP = new char[L][R][C];
			for (int l = 0; l < L; l++) {
				for (int r = 0; r < R; r++) {
					MAP[l][r] = br.readLine().toCharArray();
				}
				br.readLine();
			}

			queue.clear();
			initMap();

			sb.append(bfs());
		}

		System.out.println(sb.toString());

	}

	private static String bfs() {

		while (!queue.isEmpty()) {

			Point p = queue.poll();

			for (int d = 0; d < dirs.length; d++) {
				int nl = p.l + dirs[d][0];
				int nr = p.r + dirs[d][1];
				int nc = p.c + dirs[d][2];

				if (canGo(nl, nr, nc)) {
					if (MAP[nl][nr][nc] == 'E') {
						return success[0] + (p.depth + 1) + success[1];
					}
					MAP[nl][nr][nc] = '#';
					queue.offer(new Point(nl, nr, nc, p.depth + 1));
				}
			}

		}

		return wrong;

	}

	private static boolean canGo(int l, int r, int c) {
		return l >= 0 && l < L && r >= 0 && r < R && c >= 0 && c < C && MAP[l][r][c] != '#';
	}

	private static void initMap() {

		for (int l = 0; l < L; l++) {
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (MAP[l][r][c] == 'S') {
						queue.offer(new Point(l, r, c, 0));
						return;
					}
				}
			}
		}

	}

}
