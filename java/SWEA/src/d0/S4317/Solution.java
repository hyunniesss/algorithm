package d0.S4317;

import java.util.Scanner;

public class Solution {

	static int[][] MAP;
	static int R, C;
	static boolean[][][] check;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			MAX = -1;

			R = sc.nextInt();
			C = sc.nextInt();
			MAP = new int[R][C];
			check = new boolean[R][C][626];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					MAP[i][j] = sc.nextInt();
				}
			}

			dfs(0, 0, 0);

			System.out.println("#" + t + " " + MAX);
		}

	}

	static int MAX;

	private static int dfs(int i, int r, int c) {
		if (MAX < i) {
			MAX = i;
		}
		for (; r < R - 1; r++) {
			for (; c < C - 1; c++) {
				if (canGo(r, c)) {
					makeChip(r, c, i + 1);
					MAX = dfs(i + 1, r, c + 1);
				}
			}
		}
		return MAX;

	}

	private static void makeChip(int r, int c, int i) {

		MAP[r][c] = i;
		MAP[r + 1][c] = i;
		MAP[r][c + 1] = i;
		MAP[r + 1][c + 1] = i;

	}

	private static boolean canGo(int r, int c) {
		return MAP[r][c] == 0 && MAP[r + 1][c] == 0 && MAP[r][c + 1] == 0 && MAP[r + 1][c + 1] == 0;
	}

}
