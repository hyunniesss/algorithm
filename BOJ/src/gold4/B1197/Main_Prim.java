package gold4.B1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_Prim {

	static int V, E;

	static class Edge {
		int end;
		int price;

		public Edge(int end, int price) {
			this.end = end;
			this.price = price;
		}

	}

	static List<Edge>[] adjList;
	static int[] prices; // 가중치 최소값 저장할 배열
	static int[] parents; // 부모 노드를 저장할 배열
	static boolean[] check; // 내 편인지 니 편인지 구분할 배열

	public static void main(String[] args) throws IOException {

		initGame();

		prim();
	}

	static final int INF = Integer.MAX_VALUE;

	private static void prim() {

		Arrays.fill(prices, INF);

		parents[0] = -1; // 시작점의 부모는 없어
		prices[0] = 0; // 0에서 시작할거야

		for (int i = 1; i <= V; i++) { // 루트노드를 제외한 V-1개의 나머지 노드를 구할거야
			int min = Integer.MAX_VALUE;
			int idx = -1;
			for (int j = 0; j < V; j++) {
				Edge next = adjList[j].get(j);
				if (!check[next.end] && prices[next.end] < min) { // 니 편인 정점 중에 가중치가 지금거보다 더 작으면 업데이트
					min = prices[next.end];
					idx = next.end;
				}
			}
			System.out.println(idx);
			check[idx] = true; // 가중치 제일 작은 노드는 이제 내 편
			// 내 편으로 만든 노드에서 시작하는 노드를 가중치배열에 업데이트 해줘야해
			for (int j = 0; j < adjList[idx].size(); j++) {
				Edge next = adjList[idx].get(j);
				if (!check[next.end] && prices[j] > next.price) { // 지금 내 편 만든 정점을 찍고 다음 정점으로 간 게 더 값이 작으면
					parents[j] = idx;
					prices[j] = next.price;
				}
			}

		}
		int result = 0;
		for (int i = 1; i <= V; i++) {
			result += prices[i];
		}

		System.out.println(result);

	}

	private static void initGame() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(str.nextToken());
		E = Integer.parseInt(str.nextToken());
		prices = new int[V + 1];
		parents = new int[V + 1];
		check = new boolean[V + 1];
		adjList = new ArrayList[V + 1];

		for (int i = 1; i <= V; i++) {
			adjList[i] = new ArrayList<>();
		}

		// 이제 입력받자
		for (int i = 0; i < E; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(str.nextToken());
			int end = Integer.parseInt(str.nextToken());
			int price = Integer.parseInt(str.nextToken());

			adjList[start].add(new Edge(end, price));
			adjList[end].add(new Edge(start, price)); // 무향 그래프

		}

	}

}
