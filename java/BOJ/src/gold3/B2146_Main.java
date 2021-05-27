package gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2146_Main {

	static final int INF = Integer.MAX_VALUE;

	static int N, answer;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[][] MAP;
	static boolean[][] check;

	public static void main(String[] args) {

		initMap();
		makeIsland();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (MAP[i][j] != 0) {
					makeBridge(i, j, MAP[i][j]);
				}
			}
		}
		
		System.out.println(answer);

	}

	static class Bridge {
		int r;
		int c;
		int depth;

		public Bridge(int r, int c, int depth) {
			this.r = r;
			this.c = c;
			this.depth = depth;
		}

	}

	private static void makeBridge(int i, int j, int k) {

		for (int z = 0; z < N; z++) {
			Arrays.fill(check[z], false);
		}

		Queue<Bridge> queue = new LinkedList<>();
		queue.offer(new Bridge(i, j, 0));
		check[i][j] = true;

		while (!queue.isEmpty()) {
			Bridge cur = queue.poll();
			if (cur.depth >= answer) {
				break;
			}

			for (int d = 0; d < dirs.length; d++) {
				int nr = cur.r + dirs[d][0];
				int nc = cur.c + dirs[d][1];
				if (isIn(nr, nc) && !check[nr][nc]) {
					check[nr][nc] = true;
					if (MAP[nr][nc] == 0) { // 가보자
						queue.offer(new Bridge(nr, nc, cur.depth + 1));
					} else if (MAP[nr][nc] != k) { // 다른 섬이면 다리 건설하다가 가장 가까운 섬 찾은 것이다
						answer = Math.min(answer, cur.depth);
						return;
					}
				}
			}
		}

	}

	private static void makeIsland() {
		int idx = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (MAP[i][j] == 1 && !check[i][j]) {
					bfs(i, j, idx++);
				}
			}
		}

	}

	private static void bfs(int i, int j, int k) {

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { i, j });
		MAP[i][j] = k;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			for (int d = 0; d < dirs.length; d++) {
				int nr = cur[0] + dirs[d][0];
				int nc = cur[1] + dirs[d][1];
				if (isIn(nr, nc) && MAP[nr][nc] == 1) {
					queue.offer(new int[] { nr, nc });
					MAP[nr][nc] = k;
				}
			}
		}

	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
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
				}
			}

			answer = INF;

		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}

}
