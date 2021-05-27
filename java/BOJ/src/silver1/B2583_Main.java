package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2583_Main {

	static boolean[][] MAP;
	static int R, C;
	static ArrayList<Integer> al = new ArrayList<>();
	static Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args) {

		initMap();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!MAP[i][j]) {
					MAP[i][j] = true;
//					bfs(i, j);
					answer = 0;
					dfs(i, j);
					al.add(answer);
				}
			}
		}

		print();

	}

	static int answer;

	private static void dfs(int r, int c) {
		answer++;
		for (int d = 0; d < dirs.length; d++) {
			int nr = r + dirs[d][0];
			int nc = c + dirs[d][1];
			if (canGo(nr, nc)) {
				MAP[nr][nc] = true;
				dfs(nr, nc);
			}
		}

	}

	private static void print() {

		StringBuilder sb = new StringBuilder();
		sb.append(al.size() + "\n");
		Collections.sort(al);
		for (int i = 0; i < al.size(); i++) {
			sb.append(al.get(i) + " ");
		}

		System.out.println(sb.toString());

	}

	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	private static void bfs(int i, int j) {
		queue.clear();
		queue.offer(new int[] { i, j });
		int count = 0;
		while (!queue.isEmpty()) {
			++count;
			int[] cur = queue.poll();

			for (int d = 0; d < dirs.length; d++) {
				int nr = cur[0] + dirs[d][0];
				int nc = cur[1] + dirs[d][1];

				if (canGo(nr, nc)) {
					MAP[nr][nc] = true;
					queue.offer(new int[] { nr, nc });
				}
			}
		}
		al.add(count);
	}

	private static boolean canGo(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C && !MAP[r][c];
	}

	private static void initMap() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		try {

			str = new StringTokenizer(br.readLine(), " ");
			C = Integer.parseInt(str.nextToken());
			R = Integer.parseInt(str.nextToken());
			int K = Integer.parseInt(str.nextToken());
			MAP = new boolean[R][C];
			int x1, y1, x2, y2;
			for (int k = 0; k < K; k++) {
				str = new StringTokenizer(br.readLine(), " ");
				x1 = Integer.parseInt(str.nextToken());
				y1 = Integer.parseInt(str.nextToken());
				x2 = Integer.parseInt(str.nextToken());
				y2 = Integer.parseInt(str.nextToken());
				for (int x = x1; x < x2; x++) {
					for (int y = y1; y < y2; y++) {
						MAP[x][y] = true;
					}
				}
			}

		} catch (IOException e) {
		}

	}

}
