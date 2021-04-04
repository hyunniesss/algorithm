package gold3.B1941;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static final int N = 5, MAX = 7;
	static boolean[] check;
	static char[][] map;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new char[N][N];
		for (int r = 0; r < N; r++) {
			map[r] = br.readLine().toCharArray();
		}

		check = new boolean[N * N];

		combi(0, 0);
		
		System.out.println(answer);

	}

	private static void combi(int idx, int cur) {
		if (idx == MAX) {
			bfs();
			return;
		}

		for (int i = cur; i < N * N; i++) {
			if (!check[i]) {
				check[i] = true;
				combi(idx + 1, i + 1);
				check[i] = false;
			}
		}
	}

	static int answer;

	private static void bfs() {

		boolean[][] temp = new boolean[N][N];
		for (int i = 0; i < N * N; i++) {
			temp[i / N][i % N] = check[i];
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (temp[i][j] && go(i, j, temp)) {
					answer++;
				}
			}
		}
	}

	private static boolean go(int i, int j, boolean[][] temp) {
		int som = map[i][j] == 'S' ? 1 : 0, count = 1;
		int nr, nc;

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { i, j });
		temp[i][j] = false;

		while (!queue.isEmpty()) {

			int[] cur = queue.poll();

			for (int d = 0; d < dirs.length; d++) {
				nr = cur[0] + dirs[d][0];
				nc = cur[1] + dirs[d][1];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || !temp[nr][nc]) {
					continue;
				}

				temp[nr][nc] = false;
				queue.offer(new int[] { nr, nc });
				count++;
				som += map[nr][nc] == 'S' ? 1 : 0;
			}

		}

		if (count == MAX && som >= 4) {
			return true;
		}

		return false;

	}

}
