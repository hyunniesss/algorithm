package silver1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B9205_Main_floydwarshall {

	static final int INF = Integer.MAX_VALUE;

	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	static Point[] stores;
	static int[][] dist;
	static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			N = Integer.parseInt(br.readLine()) + 2;
			stores = new Point[N];
			dist = new int[N][N];

			for (int i = 0; i < N; i++) {
				str = new StringTokenizer(br.readLine(), " ");
				int r = Integer.parseInt(str.nextToken());
				int c = Integer.parseInt(str.nextToken());
				stores[i] = new Point(r, c);
				Arrays.fill(dist[i], INF);
			}

			floydWarshall();
			System.out.println(dist[0][N - 1] == INF && dist[N - 1][0] == INF ? "sad" : "happy");
		}
	}

	static int MAX = 1000;

	private static void floydWarshall() {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int distance = findDist(i, j);
				if (distance > 1000) {
					continue;
				}
				dist[i][j] = distance;
			}
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if (i == k || dist[i][k] == INF) {
					continue;
				}
				for (int j = 0; j < N; j++) {
					if (j == i || j == k || dist[k][j] == INF) {
						continue;
					}
					dist[i][j] = Math.min(dist[i][j], findDist(i, k) + findDist(j, k));
				}
			}
		}

	}

	private static int findDist(int i, int k) {
		return Math.abs(stores[i].r - stores[k].r) + Math.abs(stores[i].c - stores[k].c);
	}

}
