package gold5.B1916;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static final int INF = Integer.MAX_VALUE;
	static List<Point>[] adj;

	static class Point implements Comparable<Point> {
		int v; // 도착 정점
		int price; // 비용

		public Point(int v, int price) {
			this.v = v;
			this.price = price;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.price, o.price);
		}
	}

	static int V, E;
	static int[] key; // 최소비용을 저장할 배열

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer str = null;

		V = Integer.parseInt(br.readLine());
		key = new int[V + 1];

		adj = new ArrayList[V + 1];
		for (int v = 1; v <= V; v++) {
			adj[v] = new ArrayList<>();
		}

		E = Integer.parseInt(br.readLine());

		int start, end, price;
		for (int e = 0; e < E; e++) {
			str = new StringTokenizer(br.readLine(), " ");
			start = Integer.parseInt(str.nextToken());
			end = Integer.parseInt(str.nextToken());
			price = Integer.parseInt(str.nextToken());

			adj[start].add(new Point(end, price));
		}

		str = new StringTokenizer(br.readLine(), " ");
		start = Integer.parseInt(str.nextToken());
		end = Integer.parseInt(str.nextToken());

		bw.write(dijkstra(start, end) + "");

		bw.flush();
	}

	private static int dijkstra(int start, int end) {
		Arrays.fill(key, INF);
		key[start] = 0;
		PriorityQueue<Point> pq = new PriorityQueue<>();

		pq.add(new Point(start, 0));
		while (!pq.isEmpty()) {
			Point cur = pq.poll();

			for (int i = 0; i < adj[cur.v].size(); i++) {
				Point next = adj[cur.v].get(i);
				if (key[next.v] > key[cur.v] + next.price) {
					key[next.v] = key[cur.v] + next.price;
					pq.add(next);
				}
			}
		}

		return key[end];
	}

}
