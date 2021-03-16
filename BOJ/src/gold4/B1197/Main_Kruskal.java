package gold4.B1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_Kruskal {

	static int V, E, result;
	static int[] parents;
	static int[] rank;

	static class Edge implements Comparable<Edge> { // 간선 정보

		int start;
		int end;
		int price;

		public Edge(int start, int end, int price) {
			this.start = start;
			this.end = end;
			this.price = price;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.price, o.price); // 오름차순
		}

	}

	static Edge[] graph;

	public static void main(String[] args) throws IOException {

		initGame();

		kruskal();

		System.out.println(result);

	}

	private static void kruskal() {

		for (int i = 1; i <= V; i++) { // 시작할 때 내 부모노드는 나여
			parents[i] = i;
		}

		int cnt = 0;
		for (int i = 0; i < E; i++) { // 모든 간선을 돌아보면서
			int px = findSet(graph[i].start); // 시작점의 부모와
			int py = findSet(graph[i].end); // 끝점의 부모가
			if (px == py) { // 같으면 다음 간선 확인
				continue;
			}
			// 같지 않으면 같은 팀으로 만들기
			unionSet(px, py);
			result += graph[i].price;
			cnt++; // 같은 팀으로 만들었으면 내 팀의 정점 개수 추가하고
			if (cnt == V - 1) { // 날 제외한 모든 정점이 내 팀이 됐으면 포문 돌 필요가 없다
				break;
			}
		}

	}

	private static void unionSet(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if (rank[px] > rank[py]) { // px가 py보다 랭크가 높으면 px가 부모여야돼
			parents[py] = px;
		} else { // 아니면 py가 부모인데 px랑 py의 랭크가 같으면 py의 랭크를 높여서 부모임을 알려야돼
			parents[px] = py;
			if (rank[px] == rank[py]) {
				rank[py]++;
			}
		}
	}

	private static int findSet(int x) {
		if (parents[x] == x) {
			return x;
		} else {
			return findSet(parents[x]);
		}
	}

	private static void initGame() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(str.nextToken());
		E = Integer.parseInt(str.nextToken());
		parents = new int[V + 1];
		rank = new int[V + 1];
		graph = new Edge[E];

		for (int i = 0; i < E; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			int c = Integer.parseInt(str.nextToken());
			graph[i] = new Edge(a, b, c);
		}

		Arrays.sort(graph); // 가중치 오름차순으로 정렬
	}

}
