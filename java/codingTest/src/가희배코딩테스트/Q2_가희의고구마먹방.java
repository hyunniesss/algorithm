package 가희배코딩테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2_가희의고구마먹방 {

	static int T, R, C;
	static char[][] MAP;
	static int[][][] check;
	static int MAX = 0;

	public static void main(String[] args) {

		init();

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (MAP[r][c] == 'G') {
					bfs(r, c);
					System.out.println(MAX);
					return;
				}
			}
		}

	}

	static class Point {
		int r;
		int c;
		int depth;
		int count;

		public Point(int r, int c, int depth, int count) {
			this.r = r;
			this.c = c;
			this.depth = depth;
			this.count = count;
		}

	}

	private static void bfs(int r, int c) {
		check[r][c][0] = 0;
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(r, c, 0, 0));

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			MAX = Math.max(MAX, p.count);
			if (p.depth == T) {
				continue;
			}

			for (int d = 0; d < dirs.length; d++) {
				int nr = p.r + dirs[d][0];
				int nc = p.c + dirs[d][1];
				if (canGo(nr, nc)) {
					if (MAP[nr][nc] == 'S' && check[nr][nc][p.count + 1] <= p.count + 1) {
						queue.offer(new Point(nr, nc, p.depth + 1, p.count + 1));
						check[nr][nc][p.count + 1] = p.count + 1;
					} else if (MAP[nr][nc] == '.' && check[nr][nc][p.count] <= p.count) {
						queue.offer(new Point(nr, nc, p.depth + 1, p.count));
						check[nr][nc][p.count] = p.count;
					}
				}
			}

		}

	}

	private static boolean canGo(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C && MAP[r][c] != '#';
	}

	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	private static void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		try {
			str = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(str.nextToken());
			C = Integer.parseInt(str.nextToken());
			T = Integer.parseInt(str.nextToken());
			MAP = new char[R][C];
			check = new int[R][C][T + 1];

			for (int i = 0; i < R; i++) {
				MAP[i] = br.readLine().toCharArray();
			}
		} catch (IOException e) {
		}
	}

}
