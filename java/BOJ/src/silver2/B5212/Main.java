package silver2.B5212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static char[][] MAP;
	static int R, C;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int R1, R2, C1, C2;

	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {

		initMap();

		deleteMap();

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (MAP[r][c] == 'X') { // 섬이면 R1, C1, R2, C2 갱신해
					R1 = Math.min(r, R1);
					C1 = Math.min(c, C1);
					R2 = Math.max(r, R2);
					C2 = Math.max(c, C2);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int r = R1; r <= R2; r++) {
			for (int c = C1; c <= C2; c++) {
				sb.append(MAP[r][c]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());

	}

	private static void deleteMap() {
		Queue<Point> queue = new LinkedList<>();
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (MAP[r][c] == 'X' && isDel(r, c)) { // 땅이면 인접한 3칸 이상이 바다인지 확인하고 사라질 섬이면 따로 저장
					queue.offer(new Point(r, c));
				}
			}
		}
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			MAP[p.r][p.c] = '.';
		}
	}

	private static boolean isDel(int r, int c) {
		int nr, nc;
		int sea = 0;
		for (int d = 0; d < dirs.length; d++) {
			nr = r + dirs[d][0];
			nc = c + dirs[d][1];
			if (isOut(nr, nc) || MAP[nr][nc] == '.') {
				sea++;
			}
		}

		return sea >= 3;
	}

	private static boolean isOut(int r, int c) {
		return r < 0 || r >= R || c < 0 || c >= C;
	}

	private static void initMap() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		try {
			str = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(str.nextToken());
			C = Integer.parseInt(str.nextToken());
			MAP = new char[R][C];

			R1 = R - 1;
			C1 = C - 1;

			for (int r = 0; r < R; r++) {
				MAP[r] = br.readLine().toCharArray();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
