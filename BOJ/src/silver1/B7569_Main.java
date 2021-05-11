package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7569_Main {

	static int R, C, H;
	static int[][][] MAP;
	static int leftTomato;

	static class Tomato {
		int r;
		int c;
		int h;

		public Tomato(int r, int c, int h) {
			this.r = r;
			this.c = c;
			this.h = h;
		}

	}

	static Queue<Tomato> queue = new LinkedList<>();

	public static void main(String[] args) {

		initMap();
		countTomato();
		if (leftTomato == 0) {
			System.out.println(0);
		} else {
			System.out.println(bfs());
		}

	}

	private static int bfs() {
		int[][] dirs = { { -1, 0, 0 }, { 1, 0, 0 }, { 0, -1, 0 }, { 0, 1, 0 }, { 0, 0, -1 }, { 0, 0, 1 } };
		int answer = -1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			answer++;
			while (size-- > 0) {
				Tomato t = queue.poll();
				for (int d = 0; d < dirs.length; d++) {
					int nr = t.r + dirs[d][0];
					int nc = t.c + dirs[d][1];
					int nh = t.h + dirs[d][2];

					if (canGo(nr, nc, nh)) {
						queue.offer(new Tomato(nr, nc, nh));
						MAP[nr][nc][nh] = 1;
						leftTomato--;
					}
				}
			}
		}

		return leftTomato == 0 ? answer : -1;

	}

	private static boolean canGo(int r, int c, int h) {
		return r >= 0 && r < R && c >= 0 && c < C && h >= 0 && h < H && MAP[r][c][h] == 0;
	}

	private static void countTomato() {
		for (int h = 0; h < H; h++) {
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (MAP[r][c][h] == 1) {
						queue.offer(new Tomato(r, c, h));
					} else if (MAP[r][c][h] == 0) {
						leftTomato++;
					}
				}
			}
		}
	}

	private static void initMap() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;

		try {
			str = new StringTokenizer(br.readLine());
			C = Integer.parseInt(str.nextToken());
			R = Integer.parseInt(str.nextToken());
			H = Integer.parseInt(str.nextToken());

			MAP = new int[R][C][H];
			for (int h = 0; h < H; h++) {
				for (int r = 0; r < R; r++) {
					str = new StringTokenizer(br.readLine(), " ");
					for (int c = 0; c < C; c++) {
						MAP[r][c][h] = Integer.parseInt(str.nextToken());
					}
				}
			}

		} catch (IOException e) {
		}

	}

}
