package d0.S4335;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static class Box {
		int r;
		int c;
		int h;

		public Box(int r, int c, int h) {
			this.r = r;
			this.c = c;
			this.h = h;
		}

		@Override
		public String toString() {
			return "Box [r=" + r + ", c=" + c + ", h=" + h + "]";
		}

	}

	static Box[][] boxes;
	static Box[] check;
	static int N, MAX;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			MAX = -1;
			sb.append("#").append(t).append(" ");

			N = Integer.parseInt(br.readLine());
			boxes = new Box[6][N];
			for (int i = 0; i < N; i++) {
				str = new StringTokenizer(br.readLine(), " ");
				int r = Integer.parseInt(str.nextToken());
				int c = Integer.parseInt(str.nextToken());
				int h = Integer.parseInt(str.nextToken());
				MAX = Math.max(h, MAX);
				MAX = Math.max(r, MAX);
				MAX = Math.max(c, MAX);
				boxes[0][i] = new Box(r, c, h);
				boxes[1][i] = new Box(r, h, c);
				boxes[2][i] = new Box(c, r, h);
				boxes[3][i] = new Box(c, h, r);
				boxes[4][i] = new Box(h, r, c);
				boxes[5][i] = new Box(h, c, r);
			}

//			2개부터 N개까지 골라
			for (int R = 2; R <= N; R++) {
				check = new Box[R];
				permutation(R, 0, 0);
			}

			sb.append("\n");
		}
		bw.flush();
	}

	private static void permutation(int R, int cnt, int j) { // i번 형태의 j번 상자
		if (R == cnt) {
			
			return;
		}
		if(j == N) {
			return;
		}

		for (int i = 0; i < 6; i++) {
			check[j] = boxes[i][j];
			permutation(R, cnt + 1, j + 1);
		}
		permutation(R, cnt, j + 1);
	}

}
