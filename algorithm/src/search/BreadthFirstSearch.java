package search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @author hyunhee
 * 입력
5 5 3
5 4
5 2
1 2
3 4
3 1
 * 출력
3 1 4 2 5
 */

public class BreadthFirstSearch {

	static List<Integer>[] adj;
	static boolean[] check;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(str.nextToken()); // 정점 개수
		int E = Integer.parseInt(str.nextToken()); // 간선 개수
		int start = Integer.parseInt(str.nextToken()); // 시작 정점

		adj = new ArrayList[V + 1];
		check = new boolean[V + 1]; // 방문정점인지 체크할 배열
		for (int i = 1; i <= V; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			int v1 = Integer.parseInt(str.nextToken());
			int v2 = Integer.parseInt(str.nextToken());

			adj[v1].add(v2); // 여기까지 유향 그래프
			adj[v2].add(v1); // 추가시 무향 그래프
		}

		for (int i = 1; i <= V; i++) {
			Collections.sort(adj[i]); // 정점이 작은 것부터 순회
		}

		bfs(start);

	}

	private static void bfs(int start) {

		Queue<Integer> queue = new LinkedList<>(); // 방문할 정점을 담을 자료구조

		check[start] = true; // 방문 체크는 큐에 담기 전에 수행해야한다.
		queue.offer(start);

		while (!queue.isEmpty()) {

			int cur = queue.poll();

			System.out.print(cur + " "); // BFS의 방문순서 출력

			for (int i = 0; i < adj[cur].size(); i++) {
				int next = adj[cur].get(i);
				if (!check[next]) {
					check[next] = true;
					queue.offer(next);
				}
			}

		}

	}

}
