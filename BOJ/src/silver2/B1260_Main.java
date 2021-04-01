package silver2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author hyunhee 그래프
 * 
 */

public class B1260_Main {

	static boolean[][] map;
	static boolean[] check;
	static int N, V;
	static Queue<Integer> queue = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(str.nextToken());
		map = new boolean[N][N];
		check = new boolean[N];
		int M = Integer.parseInt(str.nextToken());
		V = Integer.parseInt(str.nextToken());

		for (int m = 0; m < M; m++) {
			str = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(str.nextToken());
			int e = Integer.parseInt(str.nextToken());
			map[s - 1][e - 1] = true;
			map[e - 1][s - 1] = true;
		}

		sb.append(V + " ");
		check[V - 1] = true;
		dfs(V - 1);
		sb.append("\n");
		Arrays.fill(check, false);
		check[V - 1] = true;
		queue.offer(V - 1);
		bfs();
		System.out.println(sb);

	}

	private static void dfs(int start) {
		for (int i = 0; i < N; i++) {
			if (map[start][i] && !check[i]) {
				check[i] = true;
				sb.append(i + 1 + " ");
				dfs(i);
			}
		}

	}

	private static void bfs() {
		while (!queue.isEmpty()) {
			int start = queue.poll();
			sb.append(start + 1 + " ");
			for (int i = 0; i < N; i++) {
				if (map[start][i] && !check[i]) {
					map[start][i] = false;
					check[i] = true;
					queue.offer(i);
				}
			}
		}

	}

}
