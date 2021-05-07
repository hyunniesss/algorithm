package silver5.B1063;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static String[] asd = { "R", "L", "B", "T", "RT", "LT", "RB", "LB" };
	static int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { -1, 1 }, { -1, -1 }, { 1, 1 }, { 1, -1 } };

	static class Point {
		int r;
		char c;

		public Point(int r, char c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return (c + "") + (r + "");
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		킹, 돌, 횟수
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		String a = str.nextToken();
		String b = str.nextToken();
		int N = Integer.parseInt(str.nextToken());
		Point king = new Point(a.charAt(1) - '0', change(a.charAt(0)));
		Point stone = new Point(a.charAt(1) - '0', change(a.charAt(0)));

		String dir = null;
		for (int i = 0; i < N; i++) {
			dir = br.readLine();
			int j = 0;
			for (; j < asd.length; j++) {
				if (asd[j].equals(dir)) {
					break;
				}
			}

			int kr = king.r + dirs[j][0];
			char kc = (char) (king.c + dirs[j][1]);
			if (isIn(kr, kc)) {
				if (stone.r == kr && stone.c == kc) {
					int sr = stone.r + dirs[j][0];
					char sc = (char) (stone.c + dirs[j][1]);
					if (isIn(sr, sc)) {
						stone = new Point(sr, sc);
						king = new Point(kr, kc);
					}
				} else {
					king = new Point(kr, kc);
				}
			}

		}
		king.c = change(king.c);
		stone.c = change(stone.c);
		System.out.println(king.toString());
		System.out.println(stone.toString());

	}

	private static char change(char c) {
		switch (c) {
		case 'A':
			return 'H';
		case 'B':
			return 'G';
		case 'C':
			return 'F';
		case 'D':
			return 'E';
		case 'E':
			return 'D';
		case 'F':
			return 'C';
		case 'G':
			return 'B';
		case 'H':
			return 'A';
		}
		return c;
	}

	private static boolean isIn(int r, char c) {
		return c >= 'A' && c <= 'H' && r >= 1 && r <= 8;
	}

}
