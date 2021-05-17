package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2251_Main {

	static boolean[][] check;
	static int A, B, C;

	public static void main(String[] args) {

		init();
		bfs();
	}

	static class Point {
		int a;
		int b;
		int c;

		public Point(int a, int b) {
			this.a = a;
			this.b = b;
		}

		public Point(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

	}

	static PriorityQueue<Integer> al = new PriorityQueue<>();

	private static void bfs() {

		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(0, 0, C));
		check[0][C] = true;
		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			if (cur.a == 0) {
				al.add(cur.c);
			}
			if (cur.a != 0) {
				Point next = pour(cur.a, cur.b, B); // a->b
				if (!check[next.a][cur.c]) {
					check[next.a][cur.c] = true;
					queue.offer(new Point(next.a, next.b, cur.c));
				}
				next = pour(cur.a, cur.c, C); // a->c
				if (!check[next.a][next.b]) {
					check[next.a][next.b] = true;
					queue.offer(new Point(next.a, cur.b, next.b));
				}
			}

			if (cur.b != 0) {
				Point next = pour(cur.b, cur.a, A); // b->a
				if (!check[next.b][cur.c]) {
					check[next.b][cur.c] = true;
					queue.offer(new Point(next.b, next.a, cur.c));
				}
				next = pour(cur.b, cur.c, C); // b->c
				if (!check[cur.a][next.b]) {
					check[cur.a][next.b] = true;
					queue.offer(new Point(cur.a, next.a, next.b));
				}
			}

			if (cur.c != 0) {
				Point next = pour(cur.c, cur.a, A); // c->a
				if (!check[next.b][next.a]) {
					check[next.b][next.a] = true;
					queue.offer(new Point(next.b, cur.b, next.a));
				}
				next = pour(cur.c, cur.b, B); // c->b
				if (!check[cur.a][next.a]) {
					check[cur.a][next.a] = true;
					queue.offer(new Point(cur.a, next.b, next.a));
				}
			}
		}

		print();

	}

	private static void print() {
		StringBuilder sb = new StringBuilder();
		while (!al.isEmpty()) {
			sb.append(al.poll() + " ");
		}

		System.out.println(sb.toString());

	}

	private static Point pour(int a, int b, int c) {
		if (a + b <= c) {
			b = a + b;
			a = 0;
		} else {
			a -= (c - b);
			b = c;
		}
		return new Point(a, b);
	}

	private static void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		try {
			str = new StringTokenizer(br.readLine(), " ");
		} catch (IOException e) {
			e.printStackTrace();
		}
		A = Integer.parseInt(str.nextToken());
		B = Integer.parseInt(str.nextToken());
		C = Integer.parseInt(str.nextToken());
		check = new boolean[A + 1][C + 1];
	}

}
