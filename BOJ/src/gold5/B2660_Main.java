package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B2660_Main {

	static final int INF = -1;
	static int N;
	static int[][] adj;

	public static void main(String[] args) {

		init();
		floyd();
		findMin();

	}

	private static void findMin() {
		int min = 100;
		for (int i = 1; i <= N; i++) {
			min = Math.min(adj[i][N], min);
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			if (min == adj[i][N]) {
				pq.offer(i);
			}
		}

		print(min, pq);

	}

	private static void print(int min, PriorityQueue<Integer> pq) {
		StringBuilder sb = new StringBuilder();
		sb.append(min).append(" ").append(pq.size()).append("\n");

		while (!pq.isEmpty()) {
			sb.append(pq.poll()).append(" ");
		}

		System.out.println(sb.toString());
	}

	private static void floyd() {

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if (i == k || adj[i][k] == INF) {
					continue;
				}
				for (int j = 1; j <= N; j++) {
					if (j == k || j == i || adj[k][j] == INF) {
						continue;
					}
					if (adj[i][j] == INF) {
						adj[i][j] = adj[i][k] + adj[k][j];
					} else {
						adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
					}
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			Arrays.sort(adj[i]);
		}

	}

	private static void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		try {
			N = Integer.parseInt(br.readLine());
			adj = new int[N + 1][N + 1];

			for (int i = 0; i <= N; i++) {
				Arrays.fill(adj[i], INF);
				adj[i][i] = 0;
			}

			String input = null;
			while (!"-1 -1".equals(input = br.readLine())) {
				str = new StringTokenizer(input, " ");
				int a = Integer.parseInt(str.nextToken());
				int b = Integer.parseInt(str.nextToken());
				adj[a][b] = 1;
				adj[b][a] = 1;
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

}
