package d0.S2105;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

	static int T, answer, N;
	static int sr, sc;
	static int[][] map;
	static int[][] dirs = { { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } };
	static Set<Integer> set = new HashSet<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer str = null;

		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			answer = -1;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				str = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(str.nextToken());
				}
			}

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					set.clear();
					sr = r;
					sc = c;
					dfs(sr, sc, 0);
				}
			}

			sb.append("#" + t + " ").append(answer).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();

	}

	private static void dfs(int i, int j, int d) {

		if (i == sr && j == sc) {
			if (set.size() >= 4) {
				answer = Math.max(set.size(), answer);
				return;
			}
			if (set.size() > 1) {
				return;
			}
		}

		for (int dir = d; dir < d + 2 && dir < 4; dir++) {
			int ni = i + dirs[dir][0];
			int nj = j + dirs[dir][1];
			if (canGo(ni, nj)) {
				set.add(map[ni][nj]);
				dfs(ni, nj, dir);
				set.remove(map[ni][nj]);
			}

		}

	}

	private static boolean canGo(int i, int j) {
		return i >= 0 && i < N && j >= 0 && j < N && !set.contains(map[i][j]);
	}

}
