package gold4.B1976;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BFS?

public class Main {

	static int V;
	static int M;
	static int[] pi, rank;
	static int[][] map;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		V = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		map = new int[V][V];
		pi = new int[V];
		rank = new int[V];

		for (int i = 0; i < V; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < V; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
			}
		}

		unionFind();

		str = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(str.nextToken()) - 1, end;
		while (str.hasMoreTokens()) {
			end = Integer.parseInt(str.nextToken()) - 1;
			if (start == end) {
				continue;
			}
			int px = findSet(start);
			int py = findSet(end);
			if (px != py) {
				System.out.println("NO");
				return;
			}
			start = end;
		}

		System.out.println("YES");

	}

	private static void unionFind() {

		for (int i = 0; i < V; i++) {
			makeSet(i);
		}

		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				if (map[i][j] == 0) {
					continue;
				}
				int px = findSet(i);
				int py = findSet(j);
				if (px == py) {
					continue;
				}

				unionSet(px, py);
			}
		}

	}

	private static void unionSet(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if (rank[px] > rank[py]) {
			pi[py] = px;
		} else {
			pi[px] = py;
			if (rank[px] == rank[py]) {
				rank[px]++;
			}
		}

	}

	private static int findSet(int x) {
		if (pi[x] == x) {
			return x;
		}
		return pi[x] = findSet(pi[x]);
	}

	private static void makeSet(int x) {
		pi[x] = x;
	}

}
