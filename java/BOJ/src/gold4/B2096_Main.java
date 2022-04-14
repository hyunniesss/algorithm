package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2096_Main {

	static int N;
	static final int M = 3;
	static int[][] map;

	public static void main(String[] args) {
		initIn1put();
		if (N == 1) {
			Arrays.sort(map[0]);
			System.out.println(map[0][M - 1] + " " + map[0][0]);
		} else {
			dp();
			System.out.println(MAX + " " + MIN);
		}
	}

	private static void initIn1put() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		try {
			N = Integer.parseInt(br.readLine());
			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				str = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(str.nextToken());
				}
			}
		} catch (NumberFormatException | IOException e) {
		}

	}
	static int MIN, MAX;
	private static void dp() {
		int[][] min = new int[N][M];
		for (int[] m : min) {
			Arrays.fill(m, Integer.MAX_VALUE);
		}
		int[][] max = new int[N][M];

		for (int i = 0; i < M; i++) {
			min[0][i] = max[0][i] = map[0][i];
		}
		int[][] dirs = { { 1, 0 }, { 1, -1 }, { 1, 1 } }; // 하, 좌하, 우하
		int nr, nc;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < 3; k++) {
					nr = i + dirs[k][0];
					nc = j + dirs[k][1];
					if (isIn(nr, nc)) {
						max[nr][nc] = Math.max(max[nr][nc], max[i][j] + map[nr][nc]);
						min[nr][nc] = Math.min(min[nr][nc], min[i][j] + map[nr][nc]);
					}
				}
			}
		}

		Arrays.sort(max[N - 1]);
		Arrays.sort(min[N - 1]);
		MIN = min[N-1][0];
		MAX = max[N-1][M-1];
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}
