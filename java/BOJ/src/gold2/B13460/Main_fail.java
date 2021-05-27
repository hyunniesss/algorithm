package gold2.B13460;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_fail {

	static int R, C;
	static char[][] MAP;
	static boolean[][][][][] check;

	static class Point {
		int ar;
		int ac;
		int br;
		int bc;
		int d;
		int depth;

		public Point(int ar, int ac, int br, int bc, int d, int depth) {
			this.ar = ar;
			this.ac = ac;
			this.br = br;
			this.bc = bc;
			this.d = d;
			this.depth = depth;
		}

	}

	static Queue<Point> queue = new LinkedList<>();
	static int eR, eC;

	public static void main(String[] args) {

		initMap();
		findBall();

		System.out.println(bfs());

	}

	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	private static int bfs() {

		int answer = -1;

		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			if (cur.ar == eR && cur.ac == eC && cur.br != eR && cur.bc != eC) {
				return cur.depth;
			}
			int aar, aac, bbr, bbc;
			for (int d = 0; d < dirs.length; d++) {
				aar = cur.ar;
				aac = cur.ac;
				bbr = cur.br;
				bbc = cur.bc;

				while (canGo(aar, aac) && canGo(bbr, bbc)) {
					aar += dirs[d][0];
					aac += dirs[d][1];
					bbr += dirs[d][0];
					bbc += dirs[d][1];
				}

				aar -= dirs[d][0];
				aac -= dirs[d][1];
				bbr -= dirs[d][0];
				bbc -= dirs[d][1];

				if (aar == cur.ar && aac == cur.ac && bbr == cur.br && bbc == cur.bc) {
					continue;
				}
				if (aar == bbr && aac == bbc) {
					continue;
				}
				if (!check[aar][aac][bbr][bbc][d]) {
					check[aar][aac][bbr][bbc][d] = true;
					queue.offer(new Point(aar, aac, bbr, bbc, d, cur.depth + 1));
				}

//				int flag = 0;
//				if (!canGo(aar, aac)) {
//					aar = cur.ar;
//					aac = cur.ac;
//					flag++;
//				}
//				if (!canGo(bbr, bbc)) {
//					bbr = cur.br;
//					bbc = cur.bc;
//					flag++;
//				}
//				if (flag == 2) {
//					continue;
//				}
//				if (aar == bbr && aac == bbc) {
//					continue;
//				}
//				if (!check[aar][aac][bbr][bbc]) {
//					queue.offer(new Point(aar, aac, bbr, bbc, d, cur.d == d ? cur.depth : cur.depth + 1));
//					check[aar][aac][bbr][bbc] = true;
//				}

			}
		}

		return answer;

	}

	private static boolean canGo(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C && MAP[r][c] != '#';
	}

	private static void findBall() {
		int ar = -1, ac = -1, br = -1, bc = -1;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (MAP[i][j] == 'R') {
					MAP[i][j] = '.';
					ar = i;
					ac = j;
				} else if (MAP[i][j] == 'B') {
					MAP[i][j] = '.';
					br = i;
					bc = j;
				} else if (MAP[i][j] == 'O') {
					eR = i;
					eC = j;
				}
			}
		}
		queue.offer(new Point(ar, ac, br, bc, -1, 0));

	}

	private static void initMap() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;

		try {
			str = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(str.nextToken());
			C = Integer.parseInt(str.nextToken());

			MAP = new char[R][C];
			check = new boolean[R][C][R][C][dirs.length];

			for (int i = 0; i < R; i++) {
				MAP[i] = br.readLine().toCharArray();
			}
		} catch (IOException e) {
		}

	}

}
