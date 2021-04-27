package d4.S1868;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	static int T, N;
	static char[][] map;
	static boolean[][] check;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		int answer;
		for (int t = 1; t <= T; t++) {
			answer = 0;
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			check = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == '.' && test(i, j)) {
						map[i][j] = 'C';
						check[i][j] = true;
						bfs(i, j);
						answer++;
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == '.') {
						answer++;
					}
				}
			}

			sb.append("#").append(t).append(" ").append(answer).append("\n");
			System.out.println("#" + t + " " + answer);
		}
		System.out.println(sb.toString());

	}

	private static boolean test(int i, int j) {
		int nr, nc;
		for (int d = 0; d < dirs.length; d++) {

			nr = i + dirs[d][0];
			nc = j + dirs[d][1];

			if (isOut(nr, nc)) {
				continue;
			}
			if (map[nr][nc] == '*') {
				return false;
			}

		}

		return true;
	}

	static int[][] dirs = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	private static void bfs(int r, int c) {

		int nr, nc;

		Queue<Point> queue = new LinkedList<>();

		queue.offer(new Point(r, c));
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			for (int d = 0; d < dirs.length; d++) {
				nr = p.r + dirs[d][0];
				nc = p.c + dirs[d][1];
				if (isOut(nr, nc)) {
					continue;
				}
				if (!check[nr][nc] && test(nr, nc)) {
					check[nr][nc] = true;
					map[nr][nc] = 'C';
					queue.offer(new Point(nr, nc));
				} else {
					map[nr][nc] = 'C';
				}
			}

		}

	}

	private static boolean isOut(int r, int c) {
		return r < 0 || r >= N || c < 0 || c >= N;
	}

}
