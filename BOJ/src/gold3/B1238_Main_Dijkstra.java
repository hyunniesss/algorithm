package gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1238_Main_Dijkstra {

	static class Node implements Comparable<Node> {
		int end;
		int price;

		public Node(int end, int price) {
			this.end = end;
			this.price = price;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.price, o.price);
		}
	}

	static int[] distance, answer;
	static List<Node>[] adjList;
	static int V, E, X;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(str.nextToken());
		E = Integer.parseInt(str.nextToken());
		X = Integer.parseInt(str.nextToken());
		distance = new int[V + 1]; // 편도
		answer = new int[V + 1]; // 왕복
		adjList = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			adjList[i] = new ArrayList<>();
		}

		// input
		for (int i = 0; i < E; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(str.nextToken());
			int end = Integer.parseInt(str.nextToken());
			int price = Integer.parseInt(str.nextToken());

			adjList[start].add(new Node(end, price));
		}

		for (int i = 1; i <= V; i++) { // 시작점에서 다익스트라로 X까지 거리 찾기
			if (i == X) {
				continue;
			}
			Arrays.fill(distance, INF);
			dijkstra(i);
			answer[i] += distance[X];
		}

		// 도착점에서 시작점까지 다익스트라로 거리 찾기
		Arrays.fill(distance, INF);
		dijkstra(X);
		for (int i = 1; i <= V; i++) {
			answer[i] += distance[i];
		}
		Arrays.sort(answer);

		System.out.println(answer[V]);

	}

	private static void dijkstra(int start) {

		distance[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			for (int i = 0; i < adjList[cur.end].size(); i++) {
				Node next = adjList[cur.end].get(i);
				if (distance[next.end] > cur.price + next.price) {
					distance[next.end] = cur.price + next.price;
					pq.add(new Node(next.end, distance[next.end]));
				}
			}
		}
	}

}
