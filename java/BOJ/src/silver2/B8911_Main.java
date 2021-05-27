package silver2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B8911_Main {

	static int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int T;

	static class Point {
		int r;
		int c;
		int d;

		public Point(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}

	}

	static int maxR, maxC, minR, minC;
	static Point p = null;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			initGame();
			char[] input = br.readLine().toCharArray();
			for (char c : input) {
				move(c);
			}

			System.out.println((maxR - minR) * (maxC - minC));

		}
	}

	private static void initGame() {
		maxR = 0;
		maxC = 0;
		minR = 0;
		minC = 0;
		p = new Point(0, 0, 0);

	}

	private static void move(char c) {

		if (c == 'F') {
			p.r += dirs[p.d][0];
			p.c += dirs[p.d][1];
		} else if (c == 'B') {
			p.r -= dirs[p.d][0];
			p.c -= dirs[p.d][1];
		} else if (c == 'L') {
			p.d = --p.d >= 0 ? p.d : 3;
		} else if (c == 'R') {
			p.d = ++p.d < 4 ? p.d : 0;
		}

		check(p);

	}

	private static void check(Point p) {
		maxR = Math.max(p.r, maxR);
		maxC = Math.max(p.c, maxC);
		minR = Math.min(p.r, minR);
		minC = Math.min(p.c, minC);
	}

}
