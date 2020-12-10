package gold5.B9663;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int N, answer = 0;
	static int[][] map;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dfs(1);

		System.out.println(answer);
	}

	private static void dfs(int cnt) {
		// 기저 조건 : cnt == N이면 퀸 다 배치한 것
		if (cnt == N + 1) {
			answer++;
			return;
		}
		// 1. 퀸 하나 놓고 주변에 퀸 못놓는 자리 다 제거
//		for (int r = 0; r < N; r++) {
//			for (; c < N; c++) {
//				if (map[r][c] == 0) {
//					makeMap(r, c, cnt);
//					System.out.println("BEFORE : #" + cnt);
//					for (int[] ma : map) {
//						System.out.println(Arrays.toString(ma));
//					}
//					dfs(cnt + 1, r, c + 1);
//					makeMap(cnt * (-1));
//					System.out.println("AFTER : #" + cnt);
//					for (int[] ma : map) {
//						System.out.println(Arrays.toString(ma));
//					}
//				}
//			}
//		}
		for (int c = 0; c < N; c++) {
			if (map[cnt - 1][c] == 0) {
				makeMap(cnt - 1, c, cnt);
				dfs(cnt + 1);
				makeMap(cnt - 1, c, cnt * (-1));
			}
		}

	}

	private static void makeMap(int r, int c, int check) {
		for (int d = 0; d < dirs.length; d++) {
			int nr = r + dirs[d][0];
			int nc = c + dirs[d][1];
			while (isIn(nr, nc)) {
				if (check > 0 && map[nr][nc] == 0) {
					map[nr][nc] = check; // 퀸 배치
				} else if (check < 0 && map[nr][nc] == check * (-1)) { // 퀸 제거
					map[nr][nc] = 0;
				}
				nr += dirs[d][0];
				nc += dirs[d][1];
			}
		}
		map[r][c] = check > 0 ? check : 0;
	}

	static int[][] dirs = { { -1, -1 }, { 1, 1 }, { -1, 1 }, { 1, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
