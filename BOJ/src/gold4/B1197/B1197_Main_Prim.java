package gold4.B1197;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1197_Main_Prim {

	static final int INF = Integer.MAX_VALUE;

	static class Edge implements Comparable<Edge> {
		int dest;
		int cost;

		public Edge(int dest, int cost) {
			this.dest = dest;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");

		int V = Integer.parseInt(str.nextToken());
		int E = Integer.parseInt(str.nextToken());

		// 각 정점에서 간선을 저장할 인접리스트
		List<Edge>[] adj = new ArrayList[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new ArrayList<>();
		}

		for (int e = 0; e < E; e++) {
			str = new StringTokenizer(br.readLine(), " ");
			int v1 = Integer.parseInt(str.nextToken()) - 1;
			int v2 = Integer.parseInt(str.nextToken()) - 1;
			int price = Integer.parseInt(str.nextToken());

			adj[v1].add(new Edge(v2, price));
			adj[v2].add(new Edge(v1, price));
		}

		// PQ 동기화
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		Edge[] dist = new Edge[V];

		for (int i = 1; i < V; i++) {
			dist[i] = new Edge(i, INF);
			pq.add(dist[i]);
		}

		boolean[] mst = new boolean[V];
		int result = 0;
		// 시작점 = 0
		dist[0] = new Edge(0, 0);
		pq.add(dist[0]);
		while (!pq.isEmpty()) {
			Edge e = pq.poll();
			if (mst[e.dest]) {
				continue;
			}

			mst[e.dest] = true;
			result += e.cost;

			for (Edge next : adj[e.dest]) {
				// pq에 존재하고 최소가 갱신이 된다면
				if (!mst[next.dest] && dist[next.dest].cost > next.cost) {
					dist[next.dest].cost = next.cost;
					
					// decrease key
					pq.remove(dist[next.dest]);
					pq.add(dist[next.dest]);
				}
			}
		}

		System.out.println(result);
	}

}
