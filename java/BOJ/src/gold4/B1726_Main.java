package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1726_Main {

	static int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int R, C, ER, EC, ED;
	static int[][] MAP;
	static boolean[][][] check;
	static Queue<Point> queue = new LinkedList<>();

	static class Point {
		int r;
		int c;
		int d;
		int depth;

		public Point(int r, int c, int d, int depth) {
			this.r = r;
			this.c = c;
			this.d = d;
			this.depth = depth;
		}

	}

	public static void main(String[] args) {

		init();
		System.out.println(bfs());

	}

	private static int bfs() {

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			if (p.r == ER && p.c == EC && p.d == ED) {
				return p.depth;
			}

//			go K
			for (int i = 1; i <= 3; i++) {
				int nr = p.r + (i * dirs[p.d][0]);
				int nc = p.c + (i * dirs[p.d][1]);
				if (isIn(nr, nc)) {
					if (canGo(nr, nc, p.d)) {
						check[nr][nc][p.d] = true;
						queue.offer(new Point(nr, nc, p.d, p.depth + 1));
					} else if (MAP[nr][nc] == 1) {
						break;
					}
				} else {
					break;
				}
			}

//			turn left/ right
			int d = p.d == 3 ? 0 : p.d + 1;
			if (!check[p.r][p.c][d]) {
				check[p.r][p.c][d] = true;
				queue.offer(new Point(p.r, p.c, d, p.depth + 1));
			}
			d = p.d == 0 ? 3 : p.d - 1;
			if (!check[p.r][p.c][d]) {
				check[p.r][p.c][d] = true;
				queue.offer(new Point(p.r, p.c, d, p.depth + 1));
			}
		}

		return -1;

	}

	private static boolean canGo(int r, int c, int d) {
		return MAP[r][c] == 0 && !check[r][c][d];
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

	private static void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;

		try {
			str = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(str.nextToken());
			C = Integer.parseInt(str.nextToken());
			check = new boolean[R][C][4];
			MAP = new int[R][C];
			for (int i = 0; i < R; i++) {
				str = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < C; j++) {
					MAP[i][j] = Integer.parseInt(str.nextToken());
				}
			}

			str = new StringTokenizer(br.readLine(), " ");
			int SR = Integer.parseInt(str.nextToken()) - 1;
			int SC = Integer.parseInt(str.nextToken()) - 1;
			int SD = Integer.parseInt(str.nextToken());

			SD = SD == 4 ? 0 : SD == 3 ? 2 : SD == 2 ? 3 : SD;
			queue.offer(new Point(SR, SC, SD, 0));
			check[SR][SC][SD] = true;

			str = new StringTokenizer(br.readLine(), " ");
			ER = Integer.parseInt(str.nextToken()) - 1;
			EC = Integer.parseInt(str.nextToken()) - 1;
			ED = Integer.parseInt(str.nextToken());

			ED = ED == 4 ? 0 : ED == 3 ? 2 : ED == 2 ? 3 : ED;

		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

}
