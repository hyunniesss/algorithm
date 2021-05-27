package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14502_Main {

	static int R, C; // 행, 열
	static List<Point> virus = new ArrayList<>();
	static int MAX = -1;
	static int[][] map;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(str.nextToken());
		C = Integer.parseInt(str.nextToken());
		map = new int[R][C];

		for (int r = 0; r < R; r++) {
			str = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(str.nextToken());
				if (map[r][c] == 2) {
					virus.add(new Point(r, c));
				}
			}
		}
		int cnt = 0, r = 0, c = 0;
		makeWall(cnt, r, c);

		System.out.println(MAX);

	}

	private static void makeWall(int cnt, int r, int c) {

		if (cnt == 3) {
			checkMap();
			initMap();
			return;
		}

		for (; r < R; r++) {
			for (; c < C; c++) {
				if (map[r][c] == 0) {
					map[r][c] = 1;
					makeWall(cnt + 1, r, c + 1);
					map[r][c] = 0;
				}
			}
			c = 0;
		}
	}

	private static void initMap() {

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == 3) {
					map[r][c] = 0;
				}
			}
		}

	}

	private static void checkMap() {

		Queue<Point> queue = new LinkedList<>();
		for (int i = 0; i < virus.size(); i++) {
			Point cur = virus.get(i);
			queue.offer(new Point(cur.r, cur.c));
		}

		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			for (int d = 0; d < dirs.length; d++) {
				int nr = cur.r + dirs[d][0];
				int nc = cur.c + dirs[d][1];
				if (isIn(nr, nc) && map[nr][nc] == 0) {
					map[nr][nc] = 3;
					queue.offer(new Point(nr, nc));
				}
			}
		}
		int count = 0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == 0) {
					count++;
				}
			}
		}

		MAX = Math.max(count, MAX);

	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

}
