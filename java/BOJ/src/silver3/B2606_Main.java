package silver3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2606_Main {

	static int N;
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i <= N; i++) {
			adj.add(new ArrayList<>());
		}

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			adj.get(a).add(b);
			adj.get(b).add(a); // 무향 그래프
		}

//		System.out.println(bfs(1));
		check = new boolean[N + 1];
		check[1] = true;
		dfs(1);

		System.out.println(answer);
	}

	static boolean[] check;
	static int answer = -1;

	private static void dfs(int cur) {

		ArrayList<Integer> now = adj.get(cur);

		for (int i = 0; i < now.size(); i++) {
			int next = now.get(i);
			if (!check[next]) {
				check[next] = true;
				dfs(next);
			}
		}
		answer++;

	}

	private static int bfs(int start) {

		boolean[] check = new boolean[N + 1];
		check[start] = true;
		int cnt = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		while (!queue.isEmpty()) {

			ArrayList<Integer> now = adj.get(queue.poll());

			for (int i = 0; i < now.size(); i++) {
				int next = now.get(i);
				if (!check[next]) {
					queue.offer(next);
					check[next] = true;
					cnt++;
				}
			}

		}

		return cnt;
	}

}
