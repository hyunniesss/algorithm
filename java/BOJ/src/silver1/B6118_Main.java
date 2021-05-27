package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B6118_Main {

	static int V, E;
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

	public static void main(String[] args) {

		init();
		int depth = bfs(1);
		print(depth);

	}

	private static void print(int depth) {
		StringBuilder sb = new StringBuilder();
		sb.append(pq.peek()).append(" ").append(depth).append(" ").append(pq.size());
		System.out.println(sb.toString());
	}

	static PriorityQueue<Integer> pq = new PriorityQueue<>();

	private static int bfs(int start) {

		boolean[] check = new boolean[V + 1];
		check[start] = true;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		int depth = -1;
		while (!queue.isEmpty()) {
			depth++;
			int size = queue.size();
			pq.clear();
			while (size-- > 0) {
				int cur = queue.poll();
				pq.offer(cur);
				for (int a : adj.get(cur)) {
					if (!check[a]) {
						check[a] = true;
						queue.offer(a);
					}
				}
			}
		}
		return depth;

	}

	private static void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str;
		try {
			str = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(str.nextToken());
			E = Integer.parseInt(str.nextToken());

			for (int i = 0; i <= V; i++) {
				adj.add(new ArrayList<>());
			}

			for (int i = 0; i < E; i++) {
				str = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(str.nextToken());
				int b = Integer.parseInt(str.nextToken());
				adj.get(a).add(b);
				adj.get(b).add(a);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
