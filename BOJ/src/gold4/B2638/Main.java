package gold4.B2638;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static Queue<Cheese> queue;
	static List<Cheese> cheeseList;
	static boolean[][] map;
	static int R, C;

	static class Cheese {
		int r;
		int c;

		public Cheese(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {

		initGame();
		int answer = 0;
		while (true) {
			makeCheese();
			if (queue.isEmpty()) {
				System.out.println(answer);
				return;
			}
			while (!queue.isEmpty()) {
				Cheese cheese = queue.poll();
				map[cheese.r][cheese.c] = false;
			}
			answer++;
		}

	}

	private static void makeCheese() {
		int nr, nc;
		for (int i = 0; i < cheeseList.size(); i++) {
			Cheese cheese = cheeseList.get(i);
			int count = 0;

			for (int d = 0; d < dirs.length; d++) {
				nr = cheese.r + dirs[d][0];
				nc = cheese.c + dirs[d][1];
				while (isAir(nr, nc)) {
					nr += dirs[d][0];
					nc += dirs[d][1];
					if (isOut(nr, nc)) {
						count++;
						break;
					}
				}
				if (count >= 2) {
					queue.offer(cheeseList.remove(i--));
					break;
				}
			}

		}

	}

	private static boolean isOut(int r, int c) {
		return r < 0 || r >= R || c < 0 || c >= C;
	}

	private static void initGame() throws IOException {

		queue = new LinkedList<>();
		cheeseList = new ArrayList<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(str.nextToken());
		C = Integer.parseInt(str.nextToken());

		map = new boolean[R][C];

		for (int r = 0; r < R; r++) {
			str = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < C; c++) {
				map[r][c] = "1".equals(str.nextToken());
				if (map[r][c]) {
					cheeseList.add(new Cheese(r, c));
				}

			}
		}

	}

	private static boolean isAir(int r, int c) {
		return r < 0 || r >= R || c < 0 || c >= C || (!map[r][c]);
	}

}
