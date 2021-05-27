package gold5.B17144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R, C, T;
	static Point[] air;
	static int[][] MAP;

	public static void main(String[] args) {

		initGame();

		for (int i = 0; i < T; i++) {
			doGame();
		}

	}

	static class Point {
		int r;
		int c;
		int sum;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		public Point(int r, int c, int sum) {
			this.r = r;
			this.c = c;
			this.sum = sum;
		}

	}

	static int[][] dirs = { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };
	static int[][][] airD = { { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } },
			{ { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } } };

	private static void doGame() {
//		1. 미세먼지 위치 queue에 저장
		Queue<Point> queue = new LinkedList<>();
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (MAP[r][c] > 0) {
					queue.offer(new Point(r, c));
				}
			}
		}
		Queue<Point> plus = new LinkedList<>();
//		2. 미세먼지 확장
		int nr, nc, temp, cnt;
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			temp = MAP[p.r][p.c] / 5;
			cnt = 0;
			for (int d = 0; d < dirs.length; d++) {
				nr = p.r + dirs[d][0];
				nc = p.c + dirs[d][1];
				if (canGo(nr, nc)) {
					plus.offer(new Point(nr, nc, temp));
					MAP[p.r][p.c] -= temp;
				}
			}
		}
		while (!plus.isEmpty()) {
			Point p = queue.poll();
			MAP[p.r][p.c] += p.sum;
		}

//		3. 공기청정기
		Point cur = new Point(air[0].r, air[0].c);
//		위오아왼
		int[][] airD = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		for (int d = 0; d < airD.length; d++) {
			nr = cur.r + airD[d][0];
			nc = cur.c + airD[d][0];
			while (isIn(nr, nc) && !(nr == air[0].r && nc == air[0].c)) {
				Point next = new Point(nr, nc);
				swap(cur, next);
				cur = next;
				nr = cur.r + dirs[d][0];
				nc = cur.c + dirs[d][1];
			}
		}

	}

	private static void swap(Point cur, Point next) {
		int temp = MAP[cur.r][cur.c];
		if (temp == -1) {
			temp = 0;
		}
		MAP[cur.r][cur.c] = MAP[next.r][next.c];
		MAP[next.r][next.c] = temp;
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

	private static boolean canGo(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C && MAP[r][c] >= 0;
	}

	private static void initGame() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		air = new Point[2];
		int k = 0;
		try {
			StringTokenizer str = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(str.nextToken());
			C = Integer.parseInt(str.nextToken());
			T = Integer.parseInt(str.nextToken());

			MAP = new int[R][C];
			for (int i = 0; i < R; i++) {
				str = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < C; j++) {
					MAP[i][j] = Integer.parseInt(str.nextToken());
					if (MAP[i][j] == -1) {
						air[k++] = new Point(i, j);
					}
				}
			}
		} catch (IOException e) {
		}

	}

}
