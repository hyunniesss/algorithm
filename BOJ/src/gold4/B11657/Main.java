package gold4.B11657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int V, E;
	static long[] key;

	static class Edge {
		int start;
		int end;
		long cost;

		public Edge(int start, int end, long cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

	}

	static Edge[] edges;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(str.nextToken());
		E = Integer.parseInt(str.nextToken());

		edges = new Edge[E];

		key = new long[V + 1];

		for (int i = 0; i < E; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			int c = Integer.parseInt(str.nextToken());
			edges[i] = new Edge(a, b, c);
		}

		if (bellmanFord(1)) {
			System.out.println(-1);
		} else {
			for (int i = 2; i <= V; i++) {
				System.out.println(key[i] == INF ? -1 : key[i]);
			}
		}

	}

	static final int INF = Integer.MAX_VALUE;

	private static boolean bellmanFord(int start) {

		Arrays.fill(key, INF);
		key[start] = 0;

		for (int i = 0; i < V; i++) {
			for (Edge e : edges) {
				if (key[e.start] == INF) {
					continue;
				}
				if (key[e.end] > key[e.start] + e.cost) {
					key[e.end] = key[e.start] + e.cost;
					if (i == V - 1) {
						return true;
					}
				}
			}
		}

		return false;

	}

}
