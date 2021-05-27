import java.util.Arrays;
import java.util.Scanner;

public class Kruskal {

	static int[] parents; // 부모 노드를 저장할 배열
	static int[] rank; // 부모의 우선순위를 체크할 배열

	static class Edge implements Comparable<Edge> { // 간선 정보를 저장할 클래스

		int start; // 시작정점
		int end; // 도착정점
		int price; // 가중치

		public Edge(int start, int end, int price) {
			this.start = start;
			this.end = end;
			this.price = price;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.price, o.price); // 가중치 기준으로 오름차순 정렬
		}

	}

	public static void main(String[] args) {

		int V; // 정점 개수
		int E; // 간선 개수

		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();

		parents = new int[V]; // 정점번호는 0에서 시작
		rank = new int[V];
		Edge[] edges = new Edge[E]; // 간선의 정보를 저장할 배열

		// 간선 정보 입력
		for (int i = 0; i < E; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			int price = sc.nextInt();
			edges[i] = new Edge(s, e, price);
		}

		// 1. 가중치 기준으로 간선들을 오름차순 정렬
		Arrays.sort(edges);

		// 2. 간선 배열에서 가중치가 작은 것부터 사이클을 형성하지 않으면 union해서 V-1개 찾음

		// 2-1. 각 정점에 대해 유니온파인드 준비 = 내 부모 정점은 나로 초기화
		for (int i = 0; i < V; i++) {
			makeSet(i);
		}

		int cnt = 0, result = 0;
		for (int i = 0; i < edges.length; i++) {
			int px = findSet(edges[i].start); // 시작 정점의 부모노드와
			int py = findSet(edges[i].end); // 도착 정점의 부모노드가

			// 같으면 다음 정점 볼 차례
			if (px == py) {
				continue;
			}
			// 다르면 유니온 해주고 다음 정점 또 찾으러 감
			unionSet(px, py);
			result += edges[i].price; // 지금 고른 간선의 가중치를 더해줘야 다 이으면 가중치 몇인지 알수 있어
			cnt++;
			if (cnt == V - 1) { // 루트 노드 빼고 정점 다 골랐으면 최소신장트리 완성
				break;
			}
		}
		
		System.out.println(result);

	}

	private static void makeSet(int x) {
		parents[x] = x;
	}

	private static int findSet(int x) { // 조상 찾기
		if (parents[x] == x) {
			return x;
		} else {
			return findSet(parents[x]);
		}
	}

	private static void unionSet(int x, int y) { // 부모 합치기

		int px = findSet(x);
		int py = findSet(y);

		if (rank[px] > rank[py]) {
			parents[py] = px;
		} else {
			parents[px] = py;
			if (rank[px] == rank[py]) { // 우선순위가 같으면 부모가 될 py의 우선순위 높여주기
				rank[py]++;
			}
		}

	}

}
