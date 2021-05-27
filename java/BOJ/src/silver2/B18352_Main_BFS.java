package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B18352_Main_BFS {

	static ArrayList<Integer>[] adjList;
	static ArrayList<Integer> result = new ArrayList<>();
	static int V, E, K, X;

	static class Point {
		int v;
		int count;

		public Point(int v, int count) {
			this.v = v;
			this.count = count;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(str.nextToken());
		adjList = new ArrayList[V];
		for (int v = 0; v < V; v++) {
			adjList[v] = new ArrayList<>();
		}
		E = Integer.parseInt(str.nextToken());
		K = Integer.parseInt(str.nextToken());
		X = Integer.parseInt(str.nextToken()) - 1;
		int s, e;
		for (int i = 0; i < E; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			s = Integer.parseInt(str.nextToken()) - 1;
			e = Integer.parseInt(str.nextToken()) - 1;
			adjList[s].add(e);
		}

		bfs();
		if (result.size() == 0) {
			System.out.println(-1);
		} else {
			Collections.sort(result);
			for (int i = 0; i < result.size(); i++) {
				System.out.println(result.get(i) + 1);
			}
		}

	}

	private static void bfs() {
		boolean[] check = new boolean[V];
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(X, 0));
		check[X] = true;
		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			if (cur.count == K) {
				result.add(cur.v);
				continue;
			}
			for (int i = 0; i < adjList[cur.v].size(); i++) {
				int next = adjList[cur.v].get(i);
				if (!check[next]) {
					queue.offer(new Point(next, cur.count + 1));
					check[next] = true;
				}
			}
		}

	}

}
