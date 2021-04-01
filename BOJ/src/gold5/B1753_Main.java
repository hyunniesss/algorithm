package gold5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1753_Main {

	static int V, E, K;
	static List<Edge>[] adjList;

	static class Edge implements Comparable<Edge> {
		int end;
		int price;

		public Edge(int end, int price) {
			this.end = end;
			this.price = price;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.price, o.price);
		}

	}

	static int[] key;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(str.nextToken());
		E = Integer.parseInt(str.nextToken());
		K = Integer.parseInt(br.readLine());

		adjList = new ArrayList[V + 1];
		key = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			int c = Integer.parseInt(str.nextToken());
			adjList[a].add(new Edge(b, c));
		}

		dijkstra(K);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
//			System.out.println(key[i] == INF ? "INF" : key[i]);
			if (i == K) {
				sb.append(0 + "\n");
			} else {
				sb.append(key[i] == INF ? "INF" : key[i]).append("\n");
			}
		}
		System.out.println(sb);
	}

	private static void dijkstra(int start) {

		Arrays.fill(key, INF);
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(start, 0));

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			for (int i = 0; i < adjList[cur.end].size(); i++) {
				Edge next = adjList[cur.end].get(i);
				// next.price + key[cur.end] < key[next.end] 이면 갱신
				if (key[next.end] > next.price + cur.price) {
					key[next.end] = next.price + cur.price;
					pq.remove(next);
					pq.add(new Edge(next.end, key[next.end]));
				}
			}
		}

	}

}
