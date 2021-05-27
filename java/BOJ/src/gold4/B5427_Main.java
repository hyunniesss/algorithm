package gold4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B5427_Main {

	static int R, C;
	static char[][] MAP;
	static Queue<Point> sang = new LinkedList<>();
	static Queue<Point> fire = new LinkedList<>();

	static class Point {
		int r;
		int c;
		int depth;

		public Point(int r, int c, int depth) {
			this.r = r;
			this.c = c;
			this.depth = depth;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", depth=" + depth + "]";
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			sang.clear();
			fire.clear();

			str = new StringTokenizer(br.readLine(), " ");
			C = Integer.parseInt(str.nextToken());
			R = Integer.parseInt(str.nextToken());
			MAP = new char[R + 2][C + 2];

			for (char[] temp : MAP) {
				Arrays.fill(temp, '/');
			}

			for (int r = 1; r <= R; r++) {
				char[] temp = br.readLine().toCharArray();
				for (int c = 1; c <= C; c++) {
					MAP[r][c] = temp[c - 1];
				}
			}

			initGame();
			sb.append(bfs() + "\n");

		}

		System.out.println(sb.toString());
	}

	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	private static String bfs() {

		while (!sang.isEmpty()) {
			int size = sang.size();
			while (size-- > 0) {
				Point p = sang.poll();
				if (MAP[p.r][p.c] == '*') {
					continue;
				}
				for (int d = 0; d < dirs.length; d++) {
					int nr = p.r + dirs[d][0];
					int nc = p.c + dirs[d][1];
					if (isIn(nr, nc)) {
						if (MAP[nr][nc] == '.') {
							MAP[nr][nc] = '@';
							sang.offer(new Point(nr, nc, p.depth + 1));
						} else if (MAP[nr][nc] == '/') {
							return (p.depth + 1) + "";
						}
					}
				}
			}

			size = fire.size();
			while (size-- > 0) {
				Point p = fire.poll();

				for (int d = 0; d < dirs.length; d++) {
					int nr = p.r + dirs[d][0];
					int nc = p.c + dirs[d][1];
					if (isIn(nr, nc) && (MAP[nr][nc] == '.' || MAP[nr][nc] == '@')) {
						fire.offer(new Point(nr, nc, p.depth + 1));
						MAP[nr][nc] = '*';
					}
				}
			}
		}

		return "IMPOSSIBLE";

	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r <= R + 1 && c >= 0 && c <= C + 1;
	}

	private static void initGame() {

		for (int r = 1; r <= R; r++) {
			for (int c = 1; c <= C; c++) {
				if (MAP[r][c] == '@') {
					sang.offer(new Point(r, c, 0));
				} else if (MAP[r][c] == '*') {
					fire.offer(new Point(r, c, 0));
				}
			}
		}

	}

}
