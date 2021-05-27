package gold5.B15683;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static final int INF = 5;

	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[][][] cctvD = { null, { { 0 }, { 1 }, { 2 }, { 3 } }, { { 0, 1 }, { 2, 3 } },
			{ { 0, 3 }, { 1, 3 }, { 1, 2 }, { 2, 0 } }, { { 2, 0, 3 }, { 0, 3, 1 }, { 3, 1, 2 }, { 1, 2, 0 } },
			{ { 0, 1, 2, 3 } } };

	static int[][] MAP;
	static int R, C, cctvCnt;
	static int MIN = Integer.MAX_VALUE;

	static Point[] cctvs = new Point[8];

	static class Point {
		int r;
		int c;
		int type;

		public Point(int r, int c, int type) {
			this.r = r;
			this.c = c;
			this.type = type;
		}

	}

	public static void main(String[] args) {

		makeInput();
		System.out.println(MIN);

	}

	private static void countLeft(int[][] map) {
		int count = 0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == 0) {
					count++;
				}
			}
		}

		MIN = Math.min(count, MIN);
	}

	private static boolean canGo(int r, int c, int[][] map) {
		return r >= 0 && r < R && c >= 0 && c < C && map[r][c] != 6;
	}

	private static void makeInput() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		try {
			str = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(str.nextToken());
			C = Integer.parseInt(str.nextToken());
			MAP = new int[R][C];

			for (int i = 0; i < R; i++) {
				str = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < C; j++) {
					MAP[i][j] = Integer.parseInt(str.nextToken());
					if (isCCTV(MAP[i][j])) {
						cctvs[cctvCnt++] = new Point(i, j, MAP[i][j]);
					}
				}
			}
		} catch (IOException e) {
		}

	}

	private static boolean isCCTV(int i) {
		return i >= 1 && i <= 5;
	}

}
