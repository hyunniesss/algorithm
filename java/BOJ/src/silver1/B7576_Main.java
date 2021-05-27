package silver1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7576_Main {

	static int R, C;
	static int[][] MAP;
	static Queue<int[]> queue;
	static int leftTomato;

	public static void main(String[] args) throws Exception {

		initGame();

		if (leftTomato == 0) {
			System.out.println(0);
		} else {
			System.out.println(bfs());
		}

	}

	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	private static int bfs() {
		int answer = -1;
		while (!queue.isEmpty()) {
			answer++;
			int size = queue.size();
			while (size-- > 0) {

				int[] cur = queue.poll();

				for (int d = 0; d < dirs.length; d++) {
					int nr = cur[0] + dirs[d][0];
					int nc = cur[1] + dirs[d][1];
					if (canGo(nr, nc)) {
						queue.offer(new int[] { nr, nc });
						MAP[nr][nc] = 1;
						leftTomato--;
					}
				}

			}

		}

		return leftTomato == 0 ? answer : -1;

	}

	private static boolean canGo(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C && MAP[r][c] == 0;
	}

	private static void initGame() throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		C = Integer.parseInt(str.nextToken());
		R = Integer.parseInt(str.nextToken());

		MAP = new int[R][C];

		queue = new LinkedList<>();

		for (int i = 0; i < R; i++) {
			str = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				MAP[i][j] = Integer.parseInt(str.nextToken());
				if (MAP[i][j] == 0) {
					leftTomato++;
				} else if (MAP[i][j] == 1) {
					queue.offer(new int[] { i, j });
				}
			}
		}
		

	}

}
