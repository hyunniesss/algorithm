package gold5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1916_Main {

	static final int INF = Integer.MAX_VALUE;
	static int V, E;
	static int[] key;
	static ArrayList<Edge>[] adjList;

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

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		V = Integer.parseInt(br.readLine());
		adjList = new ArrayList[V + 1];
		key = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			adjList[i] = new ArrayList<>();
		}

		E = Integer.parseInt(br.readLine());
		int a, b, c;
		for (int i = 0; i < E; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(str.nextToken());
			b = Integer.parseInt(str.nextToken());
			c = Integer.parseInt(str.nextToken());
			adjList[a].add(new Edge(b, c));
		}

		str = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(str.nextToken());
		int end = Integer.parseInt(str.nextToken());
		System.out.println(dijkstra(start, end));
	}

	private static int dijkstra(int start, int end) {

		for (int i = 1; i <= V; i++) { // 간선의 가중치가 낮은 것부터
			Collections.sort(adjList[i]);
		}

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		Arrays.fill(key, INF);
		key[start] = 0;
		pq.offer(new Edge(start, 0));
		while (!pq.isEmpty()) {

			Edge cur = pq.poll();
			for (int i = 0; i < adjList[cur.end].size(); i++) {
				Edge next = adjList[cur.end].get(i);

				if (key[next.end] > cur.price + next.price) {
					key[next.end] = cur.price + next.price;
					pq.remove(next);
					pq.add(new Edge(next.end, key[next.end]));
				}
			}

		}
		
		return key[end];
	}

}
