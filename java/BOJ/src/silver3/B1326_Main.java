package silver3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class B1326_Main {

	static int[] arr;
	static int A, B, N;

	public static void main(String[] args) {
		// 입력
		initInput();

		int answer = goBFS(A);
		System.out.println(answer);
	}

	private static void initInput() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		try {
			N = Integer.parseInt(br.readLine());
			arr = new int[N + 1];
			str = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(str.nextToken());
			}
			str = new StringTokenizer(br.readLine(), " ");
			A = Integer.parseInt(str.nextToken());
			B = Integer.parseInt(str.nextToken());
		} catch (Exception e) {
		}

	}

	static class Point {
		int cur;
		int count;

		public Point(int cur, int count) {
			this.cur = cur;
			this.count = count;
		}
	}

	private static int goBFS(int start) {
		boolean[] check = new boolean[N + 1];
		check[start] = true;

		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(start, 0));

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			if (p.cur == B) {
				return p.count;
			}

			int next = p.cur + arr[p.cur];
			while (isIn(next)) {
				if (!check[next]) {
					check[next] = true;
					queue.offer(new Point(next, p.count + 1));
				}
				next += arr[p.cur];

			}

			next = p.cur - arr[p.cur];
			while (isIn(next)) {
				if (!check[next]) {
					check[next] = true;
					queue.offer(new Point(next, p.count + 1));
				}
				next -= arr[p.cur];
			}
		}
		return -1;
	}

	private static boolean isIn(int n) {
		return n >= 1 && n <= N;
	}

}