package gold4.B1922;

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

	static int[] key; // 시작정점에서 각 정점까지의 최소비용을 저장할 배열
	static int[] pi; // 부모 정점을 저장할 배열
	static int V, E;
	static int[][] adj;
	static boolean[] check;

	static class Edge implements Comparable<Edge> { // 간선의 정보 저장할 객체
		int v;
		int price;

		public Edge(int v, int price) {
			this.v = v;
			this.price = price;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.price, o.price); // 가중치 기준으로 오름차순 정렬
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer str = null;

		V = Integer.parseInt(br.readLine());
		key = new int[V];
		pi = new int[V];
		adj = new int[V][V];
		check = new boolean[V];
		E = Integer.parseInt(br.readLine());
		for (int e = 0; e < E; e++) {
			str = new StringTokenizer(br.readLine(), " ");
			int v1 = Integer.parseInt(str.nextToken()) - 1;
			int v2 = Integer.parseInt(str.nextToken()) - 1;
			int price = Integer.parseInt(str.nextToken());

			adj[v1][v2] = price;
			adj[v2][v1] = price;
		} // end input

		int answer = prim();
		bw.write(answer + "");
		bw.flush();

	}

	private static int prim() {
		// 1. 최소비용의 시작은 무한대
		Arrays.fill(key, INF);

		// 2. 시작할 임의의 정점 하나 선택
		pi[0] = -1;
		key[0] = 0;

		for (int i = 0; i < V - 1; i++) {
			int min = Integer.MAX_VALUE;
			int index = -1;
			for (int j = 0; j < V; j++) {
				if (!check[j] && key[j] < min) {
					index = j;
					min = key[j];
				}
			}

			check[index] = true; // 최소비용을 가진 정점 선택

			for (int j = 0; j < V; j++) { // 선택하지 않은 정점 중에 현재 고른 정점이랑 이어진 간선이 존재하고 이전에 저장한 key값보다 작으면 갱신
				if (!check[j] && adj[index][j] != 0 && key[j] > adj[index][j]) {
					pi[j] = index;
					key[j] = adj[index][j];
				}
			}
		}
		int result = 0;
		for (int i = 0; i < V; i++) {
			result += key[i];
		}
		
		return result;
	}

	static final int INF = Integer.MAX_VALUE;

//	private static int dijkstra(int start) {
//
//		PriorityQueue<Edge> pq = new PriorityQueue<>();
//		Arrays.fill(key, INF);
//
//		// 임의의 시작정점
//		key[start] = 0;
//		pq.offer(new Edge(start, 0));
//
//		while (!pq.isEmpty()) {
//
//			Edge cur = pq.poll();
//			System.out.println(Arrays.toString(key));
//			for (int i = 0; i < adj[cur.v].size(); i++) { // 꺼낸 정점에서 나오는 간선들
//				Edge next = adj[cur.v].get(i);
//
//				if (key[next.v] > key[cur.v] + next.price) {
//					key[next.v] = key[cur.v] + next.price;
//					pq.add(next);
//				}
//
//			}
//		}
//		int result = 0;
//		for (int i = 0; i < V; i++) {
//			result += key[i];
//		}
//		System.out.println(result);
//		System.out.println("--------------------------------------------------");
//		return result;
//	}

}
