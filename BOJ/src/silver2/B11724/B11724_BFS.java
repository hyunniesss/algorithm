package silver2.B11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class B11724_BFS {

	static List<Integer>[] map;
	static boolean[] check;
	static int count;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());

		map = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			map[i] = new ArrayList<>();
		}
		for (int m = 0; m < M; m++) {
			str = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			map[a].add(b);
			map[b].add(a);
		}
		check = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			if (!check[i]) {
				check[i] = true;
				bfs(i);
				count++;
			}
		}

		System.out.println(count);

	}

	private static void bfs(int cur) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(cur);
		while (!queue.isEmpty()) {
			int parent = queue.poll();
			for (int i = 0; i < map[parent].size(); i++) {
				int son = map[parent].get(i);
				if (!check[son]) {
					queue.offer(son);
					check[son] = true;
				}
			}
		}
	}

}
