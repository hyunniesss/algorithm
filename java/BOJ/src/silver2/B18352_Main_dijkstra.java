package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B18352_Main_dijkstra {

	static class Edge implements Comparable<Edge> {
		int v;
		int cost;

		public Edge(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}

	}

	static int V, E, K, X;
	static ArrayList<Edge>[] adjList;
	static int[] key;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(str.nextToken());
		adjList = new ArrayList[V];
		for (int v = 0; v < V; v++) {
			adjList[v] = new ArrayList<>();
		}
		key = new int[V];
		E = Integer.parseInt(str.nextToken());
		K = Integer.parseInt(str.nextToken());
		X = Integer.parseInt(str.nextToken()) - 1;
		int s, e;
		for (int i = 0; i < E; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			s = Integer.parseInt(str.nextToken()) - 1;
			e = Integer.parseInt(str.nextToken()) - 1;
			adjList[s].add(new Edge(e, 1));
		}

		dijkstra();
		int count = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < V; i++) {
			if (key[i] == K) {
				sb.append(i + 1).append("\n");
				count++;
			}
		}

		System.out.println(count == 0 ? -1 : sb);

	}

	static final int INF = Integer.MAX_VALUE;

	private static void dijkstra() {
		Arrays.fill(key, INF);
		key[X] = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(X, 0));
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			for (int i = 0; i < adjList[cur.v].size(); i++) {
				Edge next = adjList[cur.v].get(i);
				if (key[next.v] > cur.cost + next.cost) {
					key[next.v] = cur.cost + next.cost;
					pq.add(new Edge(next.v, key[next.v]));
				}
			}
		}
	}

}
