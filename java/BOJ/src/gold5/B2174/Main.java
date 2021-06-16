package gold5.B2174;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static String direction = "NESW";
	static int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int N, M;

	static class Robot {
		int r;
		int c;
		int d;

		public Robot(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}

	}

	static class Order {
		int robot;
		String o;
		int count;

		public Order(int robot, String o, int count) {
			this.robot = robot;
			this.o = o;
			this.count = count;
		}

	}

	static int R, C;
	static int[][] check;
	static Robot[] robots;
	static Queue<Order> queue = new LinkedList<>();

	public static void main(String[] args) {

		initMap();

		while (!queue.isEmpty()) {
			Order order = queue.poll();

			for (int i = 0; i < order.count; i++) {
				Robot cur = robots[order.robot];

				switch (order.o) {
				case "L":
					cur.d = cur.d == 0 ? 3 : cur.d - 1;
					break;
				case "R":
					cur.d = cur.d == 3 ? 0 : cur.d + 1;
					break;
				case "F":
					check[cur.r][cur.c] = 0;
					cur.r += dirs[cur.d][0];
					cur.c += dirs[cur.d][1];
					if (isIn(cur.r, cur.c) && canGo(cur.r, cur.c)) { // 갈 수 있으면
						check[cur.r][cur.c] = order.robot;
					} else if (isIn(cur.r, cur.c)) {
						System.out.println("Robot " + order.robot + " crashes into robot " + check[cur.r][cur.c]);
						return;
					} else {
						System.out.println("Robot " + order.robot + " crashes into the wall");
						return;
					}
				}
			}
		}

		System.out.println("OK");

	}

	private static boolean isIn(int r, int c) {
		return r > 0 && r <= R && c > 0 && c <= C;
	}

	private static boolean canGo(int r, int c) {
		return check[r][c] == 0;
	}

	private static void initMap() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		try {
			str = new StringTokenizer(br.readLine(), " ");
		} catch (IOException e) {
		}
		R = Integer.parseInt(str.nextToken());
		C = Integer.parseInt(str.nextToken());
		check = new int[R + 1][C + 1];

		try {
			str = new StringTokenizer(br.readLine(), " ");
		} catch (IOException e) {
		}
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());

		robots = new Robot[N + 1];
		for (int i = 1; i <= N; i++) {
			try {
				str = new StringTokenizer(br.readLine(), " ");
			} catch (IOException e) {
			}
			int r = Integer.parseInt(str.nextToken());
			int c = Integer.parseInt(str.nextToken());
			int d = direction.indexOf(str.nextToken()); // "NESW"
			robots[i] = new Robot(r, c, d);
			check[r][c] = i;
		}

		for (int i = 0; i < M; i++) {
			try {
				str = new StringTokenizer(br.readLine(), " ");
			} catch (IOException e) {
			}
			int robot = Integer.parseInt(str.nextToken());
			String order = str.nextToken();
			int count = Integer.parseInt(str.nextToken());
			queue.offer(new Order(robot, order, count));
		}
	}

}
