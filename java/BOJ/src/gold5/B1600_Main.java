package gold5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1600_Main {

	static int K;
	static int R, C;
	static boolean[][] map;
	static boolean[][][] check; // r, c, k : 말이동방식

	static class Point {
		int r;
		int c;
		int k;
		int time;

		public Point(int r, int c, int k, int time) {
			this.r = r;
			this.c = c;
			this.k = k;
			this.time = time;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		initGame();
		String answer = bfs();
		bw.write(answer);
		bw.flush();

	}

	static int[][] horse = { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 } };
	static int[][] monkey = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	private static String bfs() {

		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(0, 0, 0, 0));
		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			if (cur.r == R - 1 && cur.c == C - 1) {
				return cur.time+"";
			}
			int nr, nc;
			if (cur.k < K) { // 말의 이동이 가능하다면
				for (int d = 0; d < horse.length; d++) {
					nr = cur.r + horse[d][0];
					nc = cur.c + horse[d][1];
					if (canGo(nr, nc, cur.k + 1)) {
//						if (nr == R - 1 && nc == C - 1) {
//							return (cur.time + 1) + "";
//						}
						check[nr][nc][cur.k + 1] = true;
						queue.offer(new Point(nr, nc, cur.k + 1, cur.time + 1));
					}
				}
			}

			for (int d = 0; d < monkey.length; d++) {
				nr = cur.r + monkey[d][0];
				nc = cur.c + monkey[d][1];
				if (canGo(nr, nc, cur.k)) {
//					if (nr == R - 1 && nc == C - 1) {
//						return (cur.time + 1) + "";
//					}
					check[nr][nc][cur.k] = true;
					queue.offer(new Point(nr, nc, cur.k, cur.time + 1));
				}
			}

		}

		return "-1";

	}

	private static boolean canGo(int r, int c, int k) {

		return r >= 0 && r < R && c >= 0 && c < C && map[r][c] && !check[r][c][k];
	}

	private static void initGame() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		C = Integer.parseInt(str.nextToken());
		R = Integer.parseInt(str.nextToken());

		map = new boolean[R][C];
		check = new boolean[R][C][K + 1];

		for (int r = 0; r < R; r++) {
			str = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < C; c++) {
				map[r][c] = "0".equals(str.nextToken());
			}
		}
	}

}
