package d0.S5656;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int T, N, R, C;
	static int[][] MAP;
	static int[] position;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			str = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(str.nextToken());
			C = Integer.parseInt(str.nextToken());
			R = Integer.parseInt(str.nextToken());
			MAP = new int[R][C];
			temp = new int[R][C];
			position = new int[N];
			MIN = Integer.MAX_VALUE;

			for (int r = 0; r < R; r++) {
				str = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < C; c++) {
					MAP[r][c] = Integer.parseInt(str.nextToken());
				}
			}

			// 중복허용한 cobination으로 N개의 위치를 골라
			combi(0, 0);

			sb.append("#").append(t).append(" ").append(MIN).append("\n");
		}
		System.out.println(sb.toString());

	}

	private static void combi(int cnt, int cur) {
		if (cnt == N) {
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					temp[r][c] = MAP[r][c];
				}
			}
			for (int i = 0; i < N; i++) {
				changeMAP(position[i]);
			}
			int count = 0;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					count += temp[i][j] > 0 ? 1 : 0;
				}
			}
			MIN = Math.min(MIN, count);
			return;
		}

		for (int i = cur; i < C; i++) {
			position[cnt] = i;
			combi(cnt + 1, i);
		}

	}

	static int MIN;
	static int[][] temp;

	private static void changeMAP(int c) {

		int r = 0;
		while (r < R && temp[r][c] == 0) {
			r++;
		}
		if (r == R) {
			return;
		}

		breakMap(r, c);
		renewalMap();

	}

	private static void renewalMap() {

		for (int c = 0; c < C; c++) {
			int r = R - 1, nr = r;
			while (r >= 0 && nr >= 0) {
				if (temp[nr][c] == 0) {
					nr--;
					continue;
				}
				temp[r][c] = temp[nr][c];
				while (r >= 0 && temp[r][c] != 0) {
					r--;
				}
			}
		}

	}

	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	private static void breakMap(int r, int c) {

		

	}

}
