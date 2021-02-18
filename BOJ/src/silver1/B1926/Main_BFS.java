package silver1.B1926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BFS {

	static int[][] map;
	static int R, C;
	static int maxWidth, count;
	static Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(str.nextToken());
		C = Integer.parseInt(str.nextToken());

		map = new int[R][C];
		for (int r = 0; r < R; r++) {
			str = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(str.nextToken());
			}
		} // end input
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == 1) {
					count++;
					map[r][c]++; // 방문 처리
					bfs(r, c);
				}
			}
		}

		System.out.println(count + "\n" + maxWidth);

	}

	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	private static void bfs(int r, int c) {

		queue.clear();
		queue.offer(new int[] { r, c });
		int width = 0, nr, nc;
		while (!queue.isEmpty()) {
			width++;
			int[] cur = queue.poll();
			for (int d = 0; d < dirs.length; d++) {
				nr = cur[0] + dirs[d][0];
				nc = cur[1] + dirs[d][1];
				if (canGo(nr, nc)) {
					map[nr][nc]++;
					queue.offer(new int[] { nr, nc });
				}
			}
		}
		maxWidth = Math.max(maxWidth, width);
	}

	private static boolean canGo(int r, int c) {
		return !(r < 0 || r >= R || c < 0 || c >= C) && map[r][c] == 1;
	}

}
