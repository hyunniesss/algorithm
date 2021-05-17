package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B5567_Main {

	static int V, E;
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

	public static void main(String[] args) {

		init();
		System.out.println(bfs());

	}

	private static int bfs() {

		Queue<Integer> q = new LinkedList<>();
		boolean[] check = new boolean[V + 1];
		check[1] = true;

		for (int i : adj.get(1)) {
			q.offer(i);
			check[i] = true;
		}
		int answer = q.size();

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i : adj.get(cur)) {
				if (!check[i]) {
					check[i] = true;
					answer++;
				}
			}
		}

		return answer;
	}

	private static void init() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;

		try {
			V = Integer.parseInt(br.readLine());
			E = Integer.parseInt(br.readLine());

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
		}

	}

}
