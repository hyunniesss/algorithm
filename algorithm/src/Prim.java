import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Prim {

	static int[] pi; // 각 정점의 부모 노드를 저장할 배열
	static int[] key; // 선택한 정점들 중에서 각 정점까지의 최소비용을 저장할 배열
	static int[][] adj; // 간선 정보를 저장할 배열 = 간선이 충분히 많을 때 사용하는 prim 알고리즘
	static boolean[] check; // 니 편인지 내 편인지 구분할 배열
	static int V, E;

	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		V = sc.nextInt(); // 정점 개수
		E = sc.nextInt(); // 간선 개수

		pi = new int[V]; // 정점은 0부터 시작
		key = new int[V];
		adj = new int[V][V];
		check = new boolean[V];

		for (int e = 0; e < E; e++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int price = sc.nextInt();
			adj[start][end] = price;
			adj[end][start] = price;
		}

		prim();

		int result = 0;
		for (int i = 0; i < V; i++) {
			result += key[i];
		}
		System.out.println(result);
		System.out.println(Arrays.toString(key));

	}

	private static void prim() {
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

	}

}
