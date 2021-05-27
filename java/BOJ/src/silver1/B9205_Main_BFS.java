package silver1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B9205_Main_BFS {

	static final int INF = 1000;

	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	static Point[] stores;
	static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());
			stores = new Point[N];
			str = new StringTokenizer(br.readLine(), " ");
			Point sg = new Point(Integer.parseInt(str.nextToken()), Integer.parseInt(str.nextToken())); // 상근이
			for (int i = 0; i < N; i++) {
				str = new StringTokenizer(br.readLine(), " ");
				stores[i] = new Point(Integer.parseInt(str.nextToken()), Integer.parseInt(str.nextToken())); // 가게
			}

			str = new StringTokenizer(br.readLine(), " ");
			Point ending = new Point(Integer.parseInt(str.nextToken()), Integer.parseInt(str.nextToken())); // 페스티벌
			if (bfs(sg, ending)) {
				System.out.println("happy");
			} else {
				System.out.println("sad");
			}

		}

	}

	private static boolean bfs(Point sg, Point ending) {
		boolean[] check = new boolean[N]; // 맥주 개수
		Queue<Point> queue = new LinkedList<>();
		queue.offer(sg);
		while (!queue.isEmpty()) {

			Point cur = queue.poll();

			if (dist(ending, cur) <= INF) {
				return true;
			}

			for (int i = 0; i < N; i++) {
				int distance = dist(stores[i], cur);
				if (distance > INF) {
					continue;
				}

				if (!check[i]) {
					check[i] = true;
					queue.offer(stores[i]);
				}
			}

		}

		return false;

	}

	private static int dist(Point next, Point cur) {
		return Math.abs(cur.r - next.r) + Math.abs(cur.c - next.c);
	}

}
