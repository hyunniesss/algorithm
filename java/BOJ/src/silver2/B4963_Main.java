package silver2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B4963_Main {

	static int R, C;
	static boolean[][] MAP;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		StringBuilder sb = new StringBuilder();

		while (true) {

			str = new StringTokenizer(br.readLine(), " ");

			C = Integer.parseInt(str.nextToken());
			R = Integer.parseInt(str.nextToken());
			if (R == 0 && C == 0) {
				break;
			}
			MAP = new boolean[R][C];
			for (int i = 0; i < R; i++) {
				str = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < C; j++) {
					if ("1".equals(str.nextToken())) {
						MAP[i][j] = true;
					}
				}
			}
			int answer = 0;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (MAP[i][j]) {
						answer++;
//						bfs(i, j);
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

	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };

	private static void bfs(int i, int j) {

		MAP[i][j] = false;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { i, j });

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			for (int d = 0; d < dirs.length; d++) {
				int r = cur[0] + dirs[d][0];
				int c = cur[1] + dirs[d][1];
				if (canGo(r, c)) {
					MAP[r][c] = false;
					queue.offer(new int[] { r, c });
				}
			}
		}

	}

	private static boolean canGo(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C && MAP[r][c];
	}

}
