package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2573_Main {

	static int R, C;
	static int[][] MAP;
	static boolean[][] check;

	static class Point {
		int r;
		int c;
		int melting;

		public Point(int r, int c, int melting) {
			this.r = r;
			this.c = c;
			this.melting = melting;
		}

	}

	public static void main(String[] args) {

		initMap();

		int answer = 0;
		int danji;
		while ((danji = countDanji()) <= 1) {
			if (danji == 0) {
				answer = 0;
				break;
			}
			answer++;
			melting();
		}

		System.out.println(answer);

	}

	private static void melting() {
		Queue<Point> queue = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (MAP[i][j] > 0) {
					int sum = countSea(i, j);
					if (sum > 0) {
						queue.offer(new Point(i, j, sum));
					}
				}
			}
		}

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			MAP[p.r][p.c] -= p.melting;
		}

	}

	private static int countSea(int i, int j) {
		int count = 0;
		for (int d = 0; d < dirs.length; d++) {
			int ni = i + dirs[d][0];
			int nj = j + dirs[d][1];
			if (isIn(ni, nj) && isSea(ni, nj)) {
				count++;
			}
		}

		return count;
	}

	private static boolean isSea(int i, int j) {
		return MAP[i][j] <= 0;
	}

	private static int countDanji() {

		for (int i = 0; i < R; i++) {
			Arrays.fill(check[i], false);
		}
		int answer = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (isIsland(i, j)) {
					answer++;
					bfs(i, j);
				}
			}
		}

		return answer;

	}

	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	private static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		check[r][c] = true;
		queue.offer(new int[] { r, c });

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			for (int d = 0; d < dirs.length; d++) {
				int nr = cur[0] + dirs[d][0];
				int nc = cur[1] + dirs[d][1];

				if (isIn(nr, nc) && isIsland(nr, nc)) {
					check[nr][nc] = true;
					queue.offer(new int[] { nr, nc });
				}
			}
		}
	}

	private static boolean isIsland(int r, int c) {
		return !check[r][c] && MAP[r][c] > 0;
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

	private static void initMap() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		try {
			str = new StringTokenizer(br.readLine());

			R = Integer.parseInt(str.nextToken());
			C = Integer.parseInt(str.nextToken());

			MAP = new int[R][C];
			check = new boolean[R][C];

			for (int i = 0; i < R; i++) {
				str = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < C; j++) {
					MAP[i][j] = Integer.parseInt(str.nextToken());
				}
			}
		} catch (IOException e) {
		}

	}

}
