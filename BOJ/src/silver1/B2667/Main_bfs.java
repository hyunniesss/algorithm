package silver1.B2667;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main_bfs {

	static int N, cnt;
	static char[][] map;
	static List<Integer> al = new ArrayList<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];

		for (int r = 0; r < N; r++) {
			map[r] = br.readLine().toCharArray();
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] == '1') {
					bfs(r, c);
				}
			}
		}
		System.out.println(al.size());
		Collections.sort(al);
		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i));
		}

	}

	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	private static void bfs(int r, int c) {
		int cnt = 0;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { r, c });
		map[r][c] = '0';
		while (!queue.isEmpty()) {
			cnt++;
			int[] cur = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dirs[d][0];
				int nc = cur[1] + dirs[d][1];
				if (isIn(nr, nc) && map[nr][nc] == '1') {
					queue.offer(new int[] { nr, nc });
					map[nr][nc] = '0';
				}
			}
		}
		al.add(cnt);
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
