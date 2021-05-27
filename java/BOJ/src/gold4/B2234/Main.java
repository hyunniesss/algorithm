package gold4.B2234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] dirs = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
	static boolean[][] check;
	static int[][] MAP;

	static int R, C;
	static int[] MAX = new int[2];

	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) {

		init();
		int cnt = 0;
		for (int r = 1; r <= R; r++) {
			for (int c = 1; c <= C; c++) {
				if (!check[r][c]) {
					cnt++;
					bfs(r, c);
				}
			}
		}

	}

	private static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(r, c));
		int count = 0;
		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int d = 0; d < dirs.length; d++) {
				if ((MAP[p.r][p.c] & (1 << d)) == 0) { // 벽이 아니면
					int nr = p.r + dirs[d][0];
					int nc = p.c + dirs[d][1];
					if(!check[nr][nc]) {
						check[nr][nc]=true;
					}
				}
			}
		}

	}

	private static void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		try {
			str = new StringTokenizer(br.readLine(), " ");
			C = Integer.parseInt(str.nextToken());
			R = Integer.parseInt(str.nextToken());
			MAP = new int[R + 2][C + 2];
			check = new boolean[R + 2][C + 2];

			for (int r = 1; r <= R; r++) {
				str = new StringTokenizer(br.readLine(), " ");
				for (int c = 1; c <= C; c++) {
					MAP[r][c] = Integer.parseInt(str.nextToken());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
