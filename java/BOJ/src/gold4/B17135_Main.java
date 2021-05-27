package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B17135_Main {

	static final int MAX = 3;
	static Point[] arr;
	static int R, C, D, totalCnt;
	static int[][] MAP;
	static int answer = -1;

	static class Point implements Comparable<Point> {
		int r;
		int c;
		int depth;

		public Point(int r, int c, int depth) {
			this.r = r;
			this.c = c;
			this.depth = depth;
		}

		@Override
		public int compareTo(Point o) {
			if (this.depth == o.depth) {
				return Integer.compare(this.c, o.c);
			}
			return Integer.compare(this.depth, o.depth);
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", depth=" + depth + "]";
		}

	}

	public static void main(String[] args) {

		init();
		combi(0, 0);
		System.out.println(answer);

	}

	private static void combi(int cur, int cnt) {
		if (cnt == MAX) {
			answer = Math.max(shooting(), answer);
			return;
		}

		for (int i = cur; i < C; i++) {
			arr[cnt] = new Point(R, i, 0);
			combi(i + 1, cnt + 1);
		}

	}

	private static int shooting() {

		int[][] cloned = new int[R][C];
		for (int i = 0; i < R; i++) {
			cloned[i] = MAP[i].clone();
		}
		int cnt = 0;
		int kill = 0;
		Point[] enemy = new Point[MAX];
		while (cnt < totalCnt) {
//			0. 적 찾아서
			for (int i = 0; i < MAX; i++) {
				enemy[i] = findEnemy(arr[i], cloned);
			}
//			1. 적 죽여
			for (Point p : enemy) {
				if (p == null || cloned[p.r][p.c] == 0) {
					continue;
				}
				cloned[p.r][p.c] = 0;
				kill++;
				cnt++;
			}
//		2. 적 옮기고
			for (int c = 0; c < C; c++) {
				for (int r = R - 1; r > 0; r--) {
					swap(r, c, r - 1, c, cloned);
				}
			}

			for (int i : cloned[0]) {
				if (i == 1) {
					cnt++;
				}
			}
			Arrays.fill(cloned[0], 0);
		}

		return kill;
	}

	private static void swap(int r1, int c1, int r2, int c2, int[][] cloned) {
		int temp = cloned[r1][c1];
		cloned[r1][c1] = cloned[r2][c2];
		cloned[r2][c2] = temp;
	}

	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	private static Point findEnemy(Point start, int[][] cloned) {

		Queue<Point> queue = new LinkedList<>();
		boolean[][] check = new boolean[R][C];
		queue.offer(start);
		PriorityQueue<Point> pq = new PriorityQueue<>();
		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			if (cur.depth >= D) {
				break;
			}

			for (int d = 0; d < dirs.length; d++) {
				int nr = cur.r + dirs[d][0];
				int nc = cur.c + dirs[d][1];
				if (isIn(nr, nc) && !check[nr][nc]) {
					if (cloned[nr][nc] == 0) {
						queue.offer(new Point(nr, nc, cur.depth + 1));
					} else if (cloned[nr][nc] == 1) {
						pq.offer(new Point(nr, nc, cur.depth + 1));
					}
					check[nr][nc] = true;
				}
			}
		}
		return pq.isEmpty() ? null : pq.poll();

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
			D = Integer.parseInt(str.nextToken());
			MAP = new int[R][C];
			for (int i = 0; i < R; i++) {
				str = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < C; j++) {
					MAP[i][j] = Integer.parseInt(str.nextToken());
					if (MAP[i][j] == 1) {
						totalCnt++;
					}
				}

			}
			arr = new Point[MAX];
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
