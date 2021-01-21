package gold3.B1167;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int V, max, index;
	static List<int[]>[] graph; // 인접리스트 ([0] : 정점번호, [1] : 거리
	static boolean[] check;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		check = new boolean[V];
		graph = new ArrayList[V];
		for (int v = 0; v < V; v++) {
			graph[v] = new ArrayList<>();
		}

		for (int v = 0; v < V; v++) {
			StringTokenizer str = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(str.nextToken()) - 1;
			int end = Integer.parseInt(str.nextToken()) - 1;
			while (end >= 0) {
				int price = Integer.parseInt(str.nextToken());
				graph[start].add(new int[] { end, price });

				end = Integer.parseInt(str.nextToken()) - 1;
			}

		} // end input

//		for (int v = 0; v < V; v++) {
//			check[v] = true; // 시작정점 방문체크
//			dfs(v, 0);
//			check[v] = false;
//		}
		check[0] = true;
		dfs(0,0);
		check[0] = false;
		check[index] = true;
		dfs(index, 0);
		check[index] = false;

		System.out.println(max);
	}

	private static void dfs(int cur, int price) {

//		max = Math.max(price, max); // 최대거리 체크
		if(max < price) {
			index = cur;
			max = price;
		}

		for (int i = 0; i < graph[cur].size(); i++) {
			int[] next = graph[cur].get(i);
			if (!check[next[0]] && next[1] > 0) {
				check[next[0]] = true;
				dfs(next[0], price + next[1]);
				check[next[0]] = false;
			}
		}
	}

}
