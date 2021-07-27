package gold2.B1525;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static final int LEN = 3;
	static int[][] LAST = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 0 } };

	public static void main(String[] args) {
		int[][] map = initMap();
		int[] change = findRC(map);

		int answer = bfs(map, change[0], change[1]);
		System.out.println(answer);
	}

	private static int[] findRC(int[][] map) {
		int[] answer = new int[2];
		int r = 0, c = 0;
		while (true) {
			if (map[r][c] == 0) {
				break;
			}
			c++;
			if (c == LEN) {
				r++;
				c = 0;
			}
			if (r == LEN) {
				break;
			}
		}
		answer[0] = r;
		answer[1] = c;
		return answer;
	}

	static class Point {
		int[][] map;
		int r, c;
		int depth;

		public Point(int[][] map, int r, int c, int depth) {
			this.map = map.clone();
			this.r = r;
			this.c = c;
			this.depth = depth;
		}

	}

	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	private static int bfs(int[][] map, int r, int c) {

		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(map, r, c, 0));

		int cnt = 100;

		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			if (cur.depth == cnt) {
				return -1;
			}

			if (check(cur.map)) {
				return cur.depth;
			}

			for (int d = 0; d < dirs.length; d++) {
				int nr = cur.r + dirs[d][0];
				int nc = cur.c + dirs[d][1];
				if (isIn(nr, nc)) {
					swap(r, c, nr, nc, cur.map);
					int[] change = findRC(cur.map);
					queue.offer(new Point(cur.map, change[0], change[1], cur.depth + 1));
					swap(r, c, nr, nc, cur.map);
				}
			}
		}

		return -1;

	}

	private static void print(int[][] map) {

		for (int[] m : map) {
			System.out.println(Arrays.toString(m));
		}
		System.out.println();

	}

	private static boolean check(int[][] map) {

		for (int r = 0; r < LEN; r++) {
			for (int c = 0; c < LEN; c++) {
				if (map[r][c] == LAST[r][c]) {
					continue;
				} else {
					return false;
				}
			}
		}

		return true;
	}

	private static void swap(int r, int c, int nr, int nc, int[][] map) {
		int temp = map[r][c];
		map[r][c] = map[nr][nc];
		map[nr][nc] = temp;
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < LEN && c >= 0 && c < LEN;
	}

	private static void bfs() {

	}

	private static int[][] initMap() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		int[][] MAP = new int[3][3];
		try {
			for (int i = 0; i < LEN; i++) {
				str = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < LEN; j++) {
					MAP[i][j] = Integer.parseInt(str.nextToken());
				}
			}
		} catch (Exception e) {
		}

		return MAP.clone();

	}

}
