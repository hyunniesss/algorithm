package gold4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1922_Main_Kruskal {

	static int V, E;
	static int[] parent;
	static int[] rank;
	static Edge[] edges;

	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		int cost;

		public Edge(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost); // 가중치 기준 오름차순 정렬
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;

		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		edges = new Edge[E];
		rank = new int[V + 1];
		parent = new int[V + 1];

		int a, b, c;

		for (int i = 0; i < E; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(str.nextToken());
			b = Integer.parseInt(str.nextToken());
			c = Integer.parseInt(str.nextToken());
			edges[i] = new Edge(a, b, c);
		}

		kruskal();

	}

	private static void kruskal() {

		int result = 0;
		int cnt = 0;
		
		Arrays.sort(edges);

		for (int i = 1; i <= V; i++) {
			makeSet(i);
		}

		for (int i = 0; i < E; i++) {
			int px = findSet(edges[i].start);
			int py = findSet(edges[i].end);
			if (px == py) {
				continue;
			}
			unionSet(px, py);
			result += edges[i].cost;
			cnt++;
			if (cnt == V - 1) {
				break;
			}
		}

		System.out.println(result);
	}

	private static void unionSet(int x, int y) {

		int px = findSet(x);
		int py = findSet(y);
		if (rank[px] < rank[py]) {
			parent[px] = py;
		} else {
			parent[py] = px;
			if (rank[px] == rank[py]) {
				rank[px]++;
			}
		}

	}

	private static int findSet(int i) {
		if (parent[i] == i) {
			return i;
		} else {
			parent[i] = findSet(parent[i]);
			return parent[i];
		}
	}

	private static void makeSet(int i) {
		parent[i] = i;
	}

}
