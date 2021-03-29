package gold2.B17472;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R, C;
	static int[][] map;
	static List<Point>[] adjList;

	static class Point {
		int island;
		int cost;

		public Point(int island, int cost) {
			this.island = island;
			this.cost = cost;
		}

	}

	public static void main(String[] args) throws Exception {

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
		}
		int count = 2;
		// 섬 만들기
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == 1) {
					makeIsland(r, c, count);
					count++;
				}
			}
		}

		adjList = new ArrayList[count];
		for(int i=2;i<count;i++) {
			adjList[i] = new ArrayList<>();
		}

		// 섬끼리 간선(최단거리 다리) 놓기
		for (int r = 0; r < R; r++) {

		}

	}

	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	private static void makeIsland(int r, int c, int count) {

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { r, c });
		map[r][c] = count;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int d = 0; d < dirs.length; d++) {
				int nr = cur[0] + dirs[d][0];
				int nc = cur[1] + dirs[d][1];
				if (map[nr][nc] == 1) {
					queue.offer(new int[] { nr, nc });
					map[nr][nc] = count;
				}
			}
		}

	}

}
