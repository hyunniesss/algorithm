package gold5.B10026;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int N;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static char[][] map;
	static boolean[][][] check;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		check = new boolean[N][N][2];
		for (int n = 0; n < N; n++) {
			map[n] = br.readLine().toCharArray();
		}
		int[] answer = new int[2];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (!check[r][c][0]) { // 적록색약이 아닐 때
					check[r][c][0] = true;
					bfs(r, c, false);
					answer[0]++;
				}
				if (!check[r][c][1]) { // 적록색약일때
					check[r][c][1] = true;
					bfs(r, c, true);
					answer[1]++;
				}
			}
		}
		System.out.println(answer[0] + " " + answer[1]);
	}

	private static void bfs(int r, int c, boolean flag) { // 적록색약인가?
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { r, c });
		if (flag) {
			while (!queue.isEmpty()) {
				int[] cur = queue.poll();
				for (int d = 0; d < dirs.length; d++) {
					int nr = cur[0] + dirs[d][0];
					int nc = cur[1] + dirs[d][1];
					char color = map[cur[0]][cur[1]];
					if (isIn(nr, nc) && !check[nr][nc][1] && (color == map[nr][nc]
							|| (color == 'R' && map[nr][nc] == 'G') || (color == 'G' && map[nr][nc] == 'R'))) {
						check[nr][nc][1] = true;
						queue.offer(new int[] { nr, nc });
					}
				}

			}
		} else {
			while (!queue.isEmpty()) {
				int[] cur = queue.poll();
				for (int d = 0; d < dirs.length; d++) {
					int nr = cur[0] + dirs[d][0];
					int nc = cur[1] + dirs[d][1];
					if (isIn(nr, nc) && !check[nr][nc][0] && map[nr][nc] == map[cur[0]][cur[1]]) {
						check[nr][nc][0] = true;
						queue.offer(new int[] { nr, nc });
					}
				}
			}
		}

	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
