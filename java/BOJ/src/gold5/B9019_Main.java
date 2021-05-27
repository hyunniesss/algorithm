package gold5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B9019_Main {

	static int A, B;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			Arrays.fill(check, false);
			str = new StringTokenizer(br.readLine(), " ");
			A = Integer.parseInt(str.nextToken());
			B = Integer.parseInt(str.nextToken());

			System.out.println(findAnswer(A, B));
		}
	}

	static class Point {
		int num;
		String order;

		public Point(int num, String order) {
			this.num = num;
			this.order = order;
		}

	}

	static boolean[] check = new boolean[10001];

	private static String findAnswer(int a, int b) {

		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(a, ""));
		check[a] = true;

		while (!queue.isEmpty()) {
			Point cu = queue.poll();
			if (cu.num == B) {
				return cu.order;
			}

			int next = D(cu.num);
			if (next <= 10000 && !check[next]) {
				queue.offer(new Point(next, cu.order + "D"));
				check[next] = true;
			}

			next = S(cu.num);
			if (next <= 10000 && !check[next]) {
				queue.offer(new Point(next, cu.order + "S"));
				check[next] = true;
			}

			next = L(cu.num);
			if (next <= 10000 && !check[next]) {
				queue.offer(new Point(next, cu.order + "L"));
				check[next] = true;
			}

			next = R(cu.num);
			if (next <= 10000 && !check[next]) {
				queue.offer(new Point(next, cu.order + "R"));
				check[next] = true;
			}

		}
		return null;
	}

	private static int R(int a) {
		return a / 10 + ((a % 10) * 1000);
	}

	private static int L(int a) {
		return (a / 1000) + ((a * 10) % 10000);
	}

	private static int S(int a) {
		return a == 0 ? 9999 : a - 1;
	}

	private static int D(int a) {
		return (a * 2) % 10000;
	}
}
