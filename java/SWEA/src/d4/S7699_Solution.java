package d4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S7699_Solution {

	static int T, R, C, max;
	static char[][] map;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder result = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			result.append("#").append(t).append(" ");

			StringTokenizer str = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(str.nextToken());
			C = Integer.parseInt(str.nextToken());
			map = new char[R][C];
			max = 0;

			for (int r = 0; r < R; r++) {
				map[r] = br.readLine().toCharArray();
			}

			dfs(0, 0, 1 << (map[0][0] - 'A'), 1);

			result.append(max).append("\n");
		}
		bw.write(result.toString());
		bw.flush();

	}

	private static void dfs(int r, int c, int flag, int cnt) {
		max = Math.max(cnt, max);

		for (int d = 0; d < 4; d++) {
			int nr = r + dirs[d][0];
			int nc = c + dirs[d][1];
			if (isIn(nr, nc)) {
				int temp = map[nr][nc] - 'A';
				if ((flag & (1 << temp)) == 0) {
					dfs(nr, nc, flag | (1 << temp), cnt + 1);
				}

			}
		}
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

}
