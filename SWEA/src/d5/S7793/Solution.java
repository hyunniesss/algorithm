package d5.S7793;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

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

	static char[][] MAP;
	static int R, C;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static Queue<Point> suyeon, devil;
	static boolean[][][] check;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer str = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int answer = -1;

			str = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(str.nextToken());
			C = Integer.parseInt(str.nextToken());

			MAP = new char[R][C];
			suyeon = new LinkedList<>();
			devil = new LinkedList<>();
			check = new boolean[R][C][2];

			for (int i = 0; i < R; i++) {
				MAP[i] = br.readLine().toCharArray();
				for (int j = 0; j < C; j++) {
					if (MAP[i][j] == 'S') {
						MAP[i][j] = '.';
						suyeon.offer(new Point(i, j, 0));
						check[i][j][0] = true;
					} else if (MAP[i][j] == '*') {
						devil.offer(new Point(i, j, 0));
						check[i][j][1] = true;
					}
				}
			}
			while (suyeon.size() > 0 && answer == -1) {
				answer = bfs(new int[] { suyeon.size(), devil.size() });
			}

			sb.append("#" + t + " ").append(answer == -1 ? "GAME OVER" : answer).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();

	}

	private static int bfs(int[] size) {

		int nr, nc;
		while (size[1]-- > 0) {
			Point cur = devil.poll();
			for (int d = 0; d < dirs.length; d++) {
				nr = cur.r + dirs[d][0];
				nc = cur.c + dirs[d][1];
				if (isIn(nr, nc) && !check[nr][nc][1]) {
					if (MAP[nr][nc] == '.') {
						MAP[nr][nc] = '*';
						devil.offer(new Point(nr, nc, cur.depth + 1));
						check[nr][nc][1] = true;
					}
				}
			}
		}

		while (size[0]-- > 0) {

			Point cur = suyeon.poll();
			if (MAP[cur.r][cur.c] == 'D') {
				return cur.depth;
			}
			for (int d = 0; d < dirs.length; d++) {
				nr = cur.r + dirs[d][0];
				nc = cur.c + dirs[d][1];

				if (isIn(nr, nc) && !check[nr][nc][0]) {
					if (MAP[nr][nc] == '.' || MAP[nr][nc] == 'D') {
						suyeon.offer(new Point(nr, nc, cur.depth + 1));
						check[nr][nc][0] = true;
					}
				}

			}
		}


		return -1;
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

}
