package silver2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1012_Main {

	static int R, C, K;
	static boolean[][] MAP;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {

			str = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(str.nextToken());
			C = Integer.parseInt(str.nextToken());
			K = Integer.parseInt(str.nextToken());

			MAP = new boolean[R][C];

			for (int i = 0; i < K; i++) {
				str = new StringTokenizer(br.readLine(), " ");
				int r = Integer.parseInt(str.nextToken());
				int c = Integer.parseInt(str.nextToken());
				MAP[r][c] = true;
			}

			int answer = 0;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (MAP[i][j]) {
						answer++;
//						bfs(i, j);
						MAP[i][j] = false;
						dfs(i, j);
					}
				}
			}

			sb.append(answer + "\n");
		}
		System.out.println(sb.toString());
	}

	private static void dfs(int r, int c) {

		for (int d = 0; d < dirs.length; d++) {
			int nr = r + dirs[d][0];
			int nc = c + dirs[d][1];
			if (canGo(nr, nc)) {
				MAP[nr][nc] = false;
				dfs(nr, nc);
			}
		}
	}

	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	private static void bfs(int r, int c) {

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { r, c });
		MAP[r][c] = false;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			for (int d = 0; d < dirs.length; d++) {
				int nr = cur[0] + dirs[d][0];
				int nc = cur[1] + dirs[d][1];
				if (canGo(nr, nc)) {
					queue.offer(new int[] { nr, nc });
					MAP[nr][nc] = false;
				}
			}
		}

	}

	private static boolean canGo(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C && MAP[r][c];
	}

}
