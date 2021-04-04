package gold5.B2636;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R, C;
	static int[][] map;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(str.nextToken());
		C = Integer.parseInt(str.nextToken());
		map = new int[R][C];

		for (int r = 0; r < R; r++) {
			str = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(str.nextToken());
			}
		}
		int temp = 0;
		int hour = 0, count = 0;
		do {
			temp = bfs(0);
			if (temp == 0) {
				break;
			}
			count = temp;
			hour++;
		} while (temp > 0);

		bw.write(hour + "");
		bw.newLine();
		bw.write(count + "");
		bw.flush();

	}

	static class Cheese {
		int r;
		int c;

		public Cheese(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[][] check;

	private static int bfs(int cnt) {

		Queue<Cheese> queue = new LinkedList<>();
		check = new boolean[R][C];
		check[0][0] = true;
		queue.offer(new Cheese(0, 0));

		int nr, nc;

		while (!queue.isEmpty()) {

			Cheese cur = queue.poll();
			for (int d = 0; d < dirs.length; d++) {
				nr = cur.r + dirs[d][0];
				nc = cur.c + dirs[d][1];

				if (canGo(nr, nc)) {
					check[nr][nc] = true;
					if (map[nr][nc] == 0) {
						queue.offer(new Cheese(nr, nc));
					} else {
						map[nr][nc] = 0;
						cnt++;
					}

				}
			}

		}

		return cnt;

	}

	private static boolean canGo(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C && !check[r][c];
	}

}
