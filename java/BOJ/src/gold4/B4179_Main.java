package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B4179_Main {

	static int R, C;
	static char[][] MAP;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static Queue<Point> jihun = new LinkedList<>();
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

	}

	public static void main(String[] args) {

		init();
		System.out.println(bfs());

	}

	private static String bfs() {

		int size;
		while (!jihun.isEmpty()) {
			size = jihun.size();
			while (size-- > 0) {
				Point p = jihun.poll();
				if (MAP[p.r][p.c] == 'F') {
					continue;
				}

				for (int d = 0; d < dirs.length; d++) {
					int nr = p.r + dirs[d][0];
					int nc = p.c + dirs[d][1];
					if (isIn(nr, nc) && MAP[nr][nc] == '.') {
						jihun.offer(new Point(nr, nc, p.depth + 1));
						MAP[nr][nc] = 'J';
					}
					if (MAP[nr][nc] == '\000') {
						return (p.depth + 1) + "";
					}
				}
			}

			size = fire.size();
			while (size-- > 0) {
				Point p = fire.poll();

				for (int d = 0; d < dirs.length; d++) {
					int nr = p.r + dirs[d][0];
					int nc = p.c + dirs[d][1];
					if (isIn(nr, nc) && (MAP[nr][nc] == '.' || MAP[nr][nc] == 'J')) {
						fire.offer(new Point(nr, nc, p.depth + 1));
						MAP[nr][nc] = 'F';
					}
				}
			}
		}

		return "IMPOSSIBLE";

	}

	private static boolean isIn(int r, int c) {
		return r >= 1 && r <= R && c >= 1 && c <= C;
	}

	private static void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		try {
			str = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(str.nextToken());
			C = Integer.parseInt(str.nextToken());
			MAP = new char[R + 2][C + 2];
			for (int r = 1; r <= R; r++) {
				char[] temp = br.readLine().toCharArray();
				for (int c = 1; c <= C; c++) {
					MAP[r][c] = temp[c - 1];
					if (MAP[r][c] == 'J') {
						jihun.offer(new Point(r, c, 0));
					} else if (MAP[r][c] == 'F') {
						fire.offer(new Point(r, c, 0));
					}
				}
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

}
