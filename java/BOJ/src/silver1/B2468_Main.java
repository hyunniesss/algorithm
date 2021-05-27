package silver1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2468_Main {

	static int N;
	static int[][] MAP;
	static boolean[][] check;
	static int MAX;

	public static void main(String[] args) {

		initMap();
		int max = 0;
		while (MAX-- > 0) {
			minusMap();
			for (int i = 0; i < N; i++) {
				Arrays.fill(check[i], false);
			}
			int answer = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (canGo(i, j)) {
						answer++;
//						bfs(i, j);
						check[i][j] = true;
						dfs(i, j);
					}
				}
			}

			max = Math.max(answer, max);
		}

		System.out.println(max);

	}

	private static void dfs(int i, int j) {

		for (int d = 0; d < dirs.length; d++) {
			int nr = i + dirs[d][0];
			int nc = j + dirs[d][1];
			if (canGo(nr, nc)) {
				check[nr][nc] = true;
				dfs(nr, nc);
			}
		}

	}

	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	private static void bfs(int i, int j) {

		Queue<int[]> queue = new LinkedList<>();
		check[i][j] = true;
		queue.offer(new int[] { i, j });

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int d = 0; d < dirs.length; d++) {
				int nr = cur[0] + dirs[d][0];
				int nc = cur[1] + dirs[d][1];

				if (canGo(nr, nc)) {
					check[nr][nc] = true;
					queue.offer(new int[] { nr, nc });
				}
			}
		}

	}

	private static boolean canGo(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N && !check[r][c] && MAP[r][c] >= 0;
	}

	private static void minusMap() {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				--MAP[i][j];
			}
		}

	}

	private static void initMap() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		try {
			N = Integer.parseInt(br.readLine());
			MAP = new int[N][N];
			check = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				str = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					MAP[i][j] = Integer.parseInt(str.nextToken());
					MAX = Math.max(MAP[i][j], MAX);
				}
			}
		} catch (Exception e) {

		}
	}

}
