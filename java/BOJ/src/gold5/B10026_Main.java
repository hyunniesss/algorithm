package gold5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class B10026_Main {

	static int N;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static char[][] map;
	static boolean[][] check;

	public static void main(String[] args) throws Exception {

		initMap();
		int[] answer = new int[2];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (!check[r][c]) {
					check[r][c] = true;
//					bfs(r, c); // 적록색약이 아닐 때
					dfs(r, c);
					answer[0]++;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			Arrays.fill(check[i], false);
		}

		changeMap();

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (!check[r][c]) {
					check[r][c] = true;
//					bfs(r, c);
					dfs(r, c);
					answer[1]++;
				}
			}
		}

		System.out.println(answer[0] + " " + answer[1]);
	}

	private static void bfs(int r, int c) {

		Queue<int[]> queue = new LinkedList<>();

		queue.offer(new int[] { r, c });

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int d = 0; d < dirs.length; d++) {
				int nr = cur[0] + dirs[d][0];
				int nc = cur[1] + dirs[d][1];
				if (isIn(nr, nc) && map[nr][nc] == map[r][c]) {
					queue.offer(new int[] { nr, nc });
					check[nr][nc] = true;
				}
			}
		}

	}

	private static void dfs(int r, int c) {
		int nr, nc;
		for (int d = 0; d < dirs.length; d++) {
			nr = r + dirs[d][0];
			nc = c + dirs[d][1];
			if (isIn(nr, nc) && map[r][c] == map[nr][nc]) {
				check[nr][nc] = true;
				dfs(nr, nc);
			}
		}

	}

	private static void changeMap() {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'R') {
					map[i][j] = 'G';
				}
			}
		}

	}

	private static void initMap() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			check = new boolean[N][N];
			for (int n = 0; n < N; n++) {
				map[n] = br.readLine().toCharArray();
			}
		} catch (Exception e) {

		}

	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N && !check[r][c];
	}

}
