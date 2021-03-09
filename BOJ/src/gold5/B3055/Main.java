package gold5.B3055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R, C;
	static char[][] map;
	static Queue<Point> hedge = new LinkedList<>();
	static Queue<Point> water = new LinkedList<>();
	static int ANSWER = -1;

	static class Point {
		int r;
		int c;
		int time;

		public Point(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(str.nextToken());
		C = Integer.parseInt(str.nextToken());
		map = new char[R][C];

		for (int r = 0; r < R; r++) {
			map[r] = br.readLine().toCharArray();
			for (int c = 0; c < C; c++) {
				if (map[r][c] == 'S') {
					hedge.offer(new Point(r, c, 0));
				} else if (map[r][c] == '*') {
					water.offer(new Point(r, c, 0));
				}
			}
		}

		bfs();
		System.out.println(ANSWER == -1 ? "KAKTUS" : ANSWER);

	}

	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	private static void bfs() {
		int time = 0;
		while (!hedge.isEmpty()) {
			Point hog = hedge.poll();
			if (time == hog.time) {
				makeWater(time);
				time++;
			}

			for (int d = 0; d < dirs.length; d++) {
				int nr = hog.r + dirs[d][0];
				int nc = hog.c + dirs[d][1];

				if (isIn(nr, nc)) {
					if (map[nr][nc] == '.') {
						map[nr][nc] = 'S';
						hedge.offer(new Point(nr, nc, hog.time + 1));
					} else if (map[nr][nc] == 'D') {
						ANSWER = hog.time + 1;
						return;
					}
				}
			}

		}
	}

	private static void makeWater(int time) {
		while (!water.isEmpty() && time == water.peek().time) {
			Point cur = water.poll();

			for (int d = 0; d < dirs.length; d++) {
				int nr = cur.r + dirs[d][0];
				int nc = cur.c + dirs[d][1];
				if (isIn(nr, nc) && (map[nr][nc] == '.' || map[nr][nc] == 'S')) {
					map[nr][nc] = '*';
					water.offer(new Point(nr, nc, cur.time + 1));
				}
			}
		}
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

}
