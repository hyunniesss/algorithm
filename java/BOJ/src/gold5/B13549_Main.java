package gold5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B13549_Main {

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

	static int V = (int) Math.pow(10, 6), N, K;
	static int[] key = new int[V + 1];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(str.nextToken());
		K = Integer.parseInt(str.nextToken());

		System.out.println(dijkstra(N, K));

	}

	static final int INF = Integer.MAX_VALUE;

	private static int dijkstra(int start, int end) {

		Arrays.fill(key, INF);
		key[start] = 0;

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(start, 0));
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			int next = cur.v * 2;
			if (next <= V && key[next] > cur.cost) {
				key[next] = cur.cost;
				pq.offer(new Edge(next, key[next]));
			}
			next = cur.v + 1;
			if (next <= V && key[next] > cur.cost + 1) {
				key[next] = cur.cost + 1;
				pq.offer(new Edge(next, key[next]));
			}
			next = cur.v - 1;
			if (next >= 0 && key[next] > cur.cost + 1) {
				key[next] = cur.cost + 1;
				pq.offer(new Edge(next, key[next]));
			}
		}

		return key[end];
	}

}
