package gold3.B13459;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static char[][] map;
	static Queue<Point> queue = new LinkedList<>();
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static class Point {
		int[] red;
		int[] blue;
		int cnt;

		public Point(int[] red, int[] blue, int cnt) {
			this.red = red;
			this.blue = blue;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());

		map = new char[N][M];
		int[] red = new int[2];
		int[] blue = new int[2];
		for (int n = 0; n < N; n++) {
			map[n] = br.readLine().toCharArray();
			for (int m = 0; m < M; m++) {
				if (map[n][m] == 'R') {
					map[n][m] = '.';
					red[0] = n;
					red[1] = m;
				} else if (map[n][m] == 'B') {
					map[n][m] = '.';
					blue[0] = n;
					blue[1] = m;
				}
			}
		}

		queue.offer(new Point(red, blue, 0));

		bfs();

	}

	private static boolean bfs() {
		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			if (cur.cnt > 10) {
				break;
			}
			for (int d = 0; d < dirs.length; d++) {
				int rx = cur.red[0] + dirs[d][0];
				int ry = cur.red[1] + dirs[d][1];
				if (!isIn(rx, ry)) {
					rx = cur.red[0];
					ry = cur.red[1];
				}
				int bx = cur.blue[0] + dirs[d][0];
				int by = cur.blue[1] + dirs[d][1];
				if (!isIn(bx, by)) {
					bx = cur.blue[0];
					by = cur.blue[1];
				}
				if (isIn(rx, ry) && bx != rx && by != ry) {
					if (map[rx][ry] == '.') {
						
					} else if (map[rx][ry] == 'O') {
						return true;
					}

				} else {
					rx = cur.red[0];
					ry = cur.red[1];
				}

				if (isIn(bx, by) && map[bx][by] == '.' && bx != rx && by != ry) {

				} else {
					bx = cur.blue[0];
					by = cur.blue[1];
				}

				queue.offer(new Point(new int[] { rx, ry }, new int[] { bx, by }, cur.cnt + 1));
			}

			if (map[cur.red[0]][cur.red[1]] == 'O' && map[cur.blue[0]][cur.blue[1]] != 'O') {
				return true;
			}

		}
		return false;
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}
