package B2178;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @author hyunhee N, M(2 ≤ N, M ≤ 100) 최소 칸수 : bfs
 */

public class Main {

	static boolean[][] map;
	static int N, M;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		map = new boolean[N][M];

		for (int r = 0; r < N; r++) {
			char[] input = br.readLine().toCharArray();
			for (int c = 0; c < M; c++) {
				map[r][c] = input[c] == '1';
			}
		}

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { 0, 0, 1 });
		map[0][0] = false;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			if (cur[0] == N - 1 && cur[1] == M - 1) {
				System.out.println(cur[2]);
				return;
			}
			int nr, nc;
			for (int d = 0; d < dirs.length; d++) {
				nr = cur[0] + dirs[d][0];
				nc = cur[1] + dirs[d][1];
				if (isIn(nr, nc) && map[nr][nc]) {
					map[nr][nc] = false;
					queue.offer(new int[] { nr, nc, cur[2] + 1 });
				}
			}
		}

	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
