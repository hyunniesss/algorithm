package silver1.B16953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R, C, K, MAX = -1;
	static boolean[][] MAP;
	static int count;

	public static void main(String[] args) {

		init();
		for (int i = 0; i <= R; i++) {
			for (int j = 0; j <= C; j++) {
				if (MAP[i][j]) {
//					MAX = Math.max(bfs(i, j), MAX);
					count = 0;
					dfs(i, j);
					MAX = Math.max(count, MAX);
				}
			}
		}

		System.out.println(MAX);

	}

	private static void dfs(int r, int c) {

		int nr, nc;
		for (int d = 0; d < dirs.length; d++) {
			nr = r + dirs[d][0];
			nc = c + dirs[d][1];
			if (canGo(nr, nc)) {
				MAP[nr][nc] = false;
				dfs(nr, nc);
				count++;
			}
		}

	}

	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	private static int bfs(int r, int c) {

		Queue<int[]> queue = new LinkedList<>();
		MAP[r][c] = false;
		queue.offer(new int[] { r, c });

		int answer = 1;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			int nr, nc;
			for (int d = 0; d < dirs.length; d++) {
				nr = cur[0] + dirs[d][0];
				nc = cur[1] + dirs[d][1];
				if (canGo(nr, nc)) {
					queue.offer(new int[] { nr, nc });
					MAP[nr][nc] = false;
					answer++;
				}
			}
		}

		return answer;
	}

	private static boolean canGo(int r, int c) {
		return r >= 0 && r <= R && c >= 0 && c <= C && MAP[r][c];
	}

	private static void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		try {
			str = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(str.nextToken());
			C = Integer.parseInt(str.nextToken());
			K = Integer.parseInt(str.nextToken());

			MAP = new boolean[R + 1][C + 1];
			for (int k = 0; k < K; k++) {
				str = new StringTokenizer(br.readLine(), " ");
				MAP[Integer.parseInt(str.nextToken())][Integer.parseInt(str.nextToken())] = true;
			}
		} catch (IOException e) {
		}
	}

}
