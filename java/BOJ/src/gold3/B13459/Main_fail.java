package gold3.B13459;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_fail {

	static final int INF = 11;
	static int R, C;
	static char[][] MAP;
	static boolean[][][][] check; // RedR, RedC, BlueR, BlueC
	static Queue<Point> queue = new LinkedList<>();

	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static class Point {
		Ball redBall;
		Ball blueBall;
		int depth;

		public Point(Ball redBall, Ball blueBall, int depth) {
			this.redBall = redBall;
			this.blueBall = blueBall;
			this.depth = depth;
		}

	}

	static class Ball {
		int r;
		int c;
		int dist;

		public Ball(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}

		public Ball(Ball b) {
			this.r = b.r;
			this.c = b.c;
			this.dist = b.dist;
		}

		@Override
		public String toString() {
			return "Ball [r=" + r + ", c=" + c + ", dist=" + dist + "]";
		}

	}

	public static void main(String[] args) {

		initMap();
		findBall();

		System.out.println(bfs() ? 1 : 0);

	}

	private static boolean bfs() {

		while (!queue.isEmpty()) {
			Point now = queue.poll(); // redBall, blueBall, depth
			if (now.depth == INF) {
				break;
			}

			for (int d = 0; d < dirs.length; d++) {

				Ball redBall = new Ball(now.redBall);
				moveBall(redBall, d);
				Ball blueBall = new Ball(now.blueBall);
				moveBall(blueBall, d);
				if (blueBall.dist > 0) {
					moveBall(redBall, d);
				}
				if (redBall.r == blueBall.r && redBall.c == blueBall.c) { // 같은 위치면 한 칸 미루는데
					if (MAP[redBall.r][redBall.c] == 'O') { // 둘 다 구멍에 들어가면 안돼
						continue;
					}
					if (redBall.dist > blueBall.dist) {
						backBall(redBall, d);
					} else {
						backBall(blueBall, d);
					}
				}
				if (MAP[redBall.r][redBall.c] == 'O') { // 빨간 공이 구멍이면 끝
					return true;
				}
				if (MAP[blueBall.r][blueBall.c] == 'O') { // 파란 공이 구멍이면 끝
					continue;
				}
				if (!check[redBall.r][redBall.c][blueBall.r][blueBall.c]) {
					check[redBall.r][redBall.c][blueBall.r][blueBall.c] = true;
					redBall.dist = 0;
					blueBall.dist = 0;
					queue.offer(new Point(new Ball(redBall), new Ball(blueBall), now.depth + 1));
				}
			}
		}

		return false;
	}

	private static void backBall(Ball ball, int d) {
		ball.r -= dirs[d][0];
		ball.c -= dirs[d][1];
	}

	private static void moveBall(Ball ball, int d) {

		while (MAP[ball.r + dirs[d][0]][ball.c + dirs[d][1]] == '.') {
			ball.r += dirs[d][0];
			ball.c += dirs[d][1];
			ball.dist++;
		}
		if (MAP[ball.r + dirs[d][0]][ball.c + dirs[d][1]] == 'O') {
			ball.r += dirs[d][0];
			ball.c += dirs[d][1];
			ball.dist++;
		}

	}

	private static void findBall() {
		Ball redBall = null;
		Ball blueBall = null;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (MAP[i][j] == 'R') {
					MAP[i][j] = '.';
					redBall = new Ball(i, j, 0);
				} else if (MAP[i][j] == 'B') {
					MAP[i][j] = '.';
					blueBall = new Ball(i, j, 0);
				}
			}
		}
		queue.offer(new Point(redBall, blueBall, 0));
		check[redBall.r][redBall.c][blueBall.r][blueBall.c] = true;

	}

	private static void initMap() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;

		try {
			str = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(str.nextToken());
			C = Integer.parseInt(str.nextToken());
			MAP = new char[R][C];
			check = new boolean[R][C][R][C];

			for (int i = 0; i < R; i++) {
				MAP[i] = br.readLine().toCharArray();
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

}
