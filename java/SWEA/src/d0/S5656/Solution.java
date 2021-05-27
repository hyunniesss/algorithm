package d0.S5656;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int N, R, C;
	static int[][] MAP;
	static int[] position;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			str = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(str.nextToken());
			C = Integer.parseInt(str.nextToken());
			R = Integer.parseInt(str.nextToken());
			MAP = new int[R][C];
			temp = new int[R][C];
			position = new int[N];
			MIN = Integer.MAX_VALUE;

			for (int r = 0; r < R; r++) {
				str = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < C; c++) {
					MAP[r][c] = Integer.parseInt(str.nextToken());
				}
			}

			// 중복허용한 cobination으로 N개의 위치를 골라
			permutation(0);

			sb.append("#").append(t).append(" ").append(MIN).append("\n");
		}
		System.out.println(sb.toString());

	}

	private static void permutation(int cnt) {
		if (cnt == N) {
			test();
			return;
		}

		for (int i = 0; i < C; i++) {
			position[cnt] = i;
			permutation(cnt + 1);
		}
	}

	private static void test() {

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				temp[r][c] = MAP[r][c];
			}
		}

		for (int i = 0; i < N; i++) {
			breakMap(position[i]);
			changeMap();
		}
		int count = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (temp[i][j] > 0) {
					count++;
				}
			}
		}
		MIN = Math.min(count, MIN);

	}

	private static void changeMap() {
		Queue<int[]> queue = new LinkedList<>();
		for (int c = 0; c < C; c++) {
			queue.clear();
			for (int r = R - 1; r >= 0; r--) {
				if (temp[r][c] == 0) {
					queue.offer(new int[] { r, c });
				} else if (!queue.isEmpty()) {
					int[] pref = queue.poll();
					temp[pref[0]][pref[1]] = temp[r][c];
					temp[r][c] = 0;
					queue.offer(new int[] { r, c });
				}
			}
		}

	}

	static int MIN;
	static int[][] temp;

	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	private static void breakMap(int c) {
		int r = 0;
		while (r < R && temp[r][c] == 0) {
			r++;
		}
		if (r == R) {
			return;
		}
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { r, c });
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cnt = temp[cur[0]][cur[1]] - 1;
			temp[cur[0]][cur[1]] = 0;
			int nr, nc;
			for (int d = 0; d < dirs.length; d++) {
				nr = cur[0];
				nc = cur[1];
				for (int i = 1; i <= cnt; i++) {
					nr += dirs[d][0];
					nc += dirs[d][1];
					if (isIn(nr, nc) && temp[nr][nc] > 0) {
						queue.offer(new int[] { nr, nc });
					}
				}
			}

		}
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

}
