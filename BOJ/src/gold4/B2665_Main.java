package gold4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B2665_Main {

	static class Edge implements Comparable<Edge> {
		int r;
		int c;
		int cost;

		public Edge(int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

	static int V;
	static int[][] adj;
	static int[][] key;

	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		adj = new int[V][V];
		key = new int[V][V];

		for (int i = 0; i < V; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < V; j++) {
				adj[i][j] = input[j] == '1' ? 0 : 1; // 가중치
			}
		}
		int answer = dijkstra(0, 0);
		System.out.println(answer == INF ? 0 : answer);

	}

	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	private static int dijkstra(int r, int c) {

		int nr, nc;

		for (int i = 0; i < V; i++) {
			Arrays.fill(key[i], INF);
		}
		key[r][c] = adj[r][c];

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(r, c, key[r][c]));

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			for (int d = 0; d < dirs.length; d++) {
				nr = cur.r + dirs[d][0];
				nc = cur.c + dirs[d][1];

				if (nr < 0 || nr >= V || nc < 0 || nc >= V) {
					continue;
				}
				if (key[nr][nc] > cur.cost + adj[nr][nc]) {
					key[nr][nc] = cur.cost + adj[nr][nc];
					pq.offer(new Edge(nr, nc, key[nr][nc]));
				}
			}
		}

		return key[V - 1][V - 1];
	}

}
