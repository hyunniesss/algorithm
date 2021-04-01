package gold5.B9663;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int N, answer = 0;
	static int[][] map;
	static int[][] dirs = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dfs(1);

		System.out.println(answer);
	}

	private static void dfs(int cnt) {

		if (cnt == N + 1) {
			answer++;
			return;
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] == 0) {
					fillMap(r, c, cnt);
					dfs(cnt + 1);
					backMap(cnt);
				}
			}
		}

	}

	private static void backMap(int cnt) {

		System.out.println("BACK MAP");

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] == cnt) {
					map[r][c] = 0;
				}
			}
		}

		for (int[] m : map) {
			System.out.println(Arrays.toString(m));
		}

	}

	private static void fillMap(int r, int c, int cnt) {

		System.out.println("FILL MAP");

		for (int i = 0; i < N; i++) {
			map[i][c] = map[i][c] == 0 ? cnt : map[i][c];
			map[r][i] = map[r][i] == 0 ? cnt : map[r][i];
		}

		for (int nr = r, nc = c; nr < N && nc < N; nr++, nc++) {
			map[nr][nc] = map[nr][nc] == 0 ? cnt : map[nr][nc];
		}

		for (int nr = r, nc = c; nr >= 0 && nc >= 0; nr--, nc--) {
			map[nr][nc] = map[nr][nc] == 0 ? cnt : map[nr][nc];
		}

		for (int nr = r, nc = c; nr >= 0 && nc < N; nr--, nc++) {
			map[nr][nc] = map[nr][nc] == 0 ? cnt : map[nr][nc];
		}

		for (int nr = r, nc = c; nr < N && nc >= 0; nr++, nc--) {
			map[nr][nc] = map[nr][nc] == 0 ? cnt : map[nr][nc];
		}

		for (int[] m : map) {
			System.out.println(Arrays.toString(m));
		}

		System.out.println();

	}

}
