package silver1;

/**
 * @author hyunhee
 * 5≤N≤25
 * 1. 단지 나누기
 * 2. 단지에 속한 집의 수 세기
 * 3. map으로 key value 처리
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2667_Main_DFS {

	static int homeCNT = 2;
	static int N;
	static int[][] map;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int r = 0; r < N; r++) {
			char[] input = br.readLine().toCharArray();
			for (int c = 0; c < N; c++) {
				map[r][c] = input[c] - '0';
			}
		} // end input

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] == 1) {
					map[r][c] = homeCNT;
					dfs(r, c);
					homeCNT++;
				}
			}
		} // 단지수 세기 끝
		homeCNT--;
		int[] home = new int[homeCNT];

		while (homeCNT > 1) {
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] == homeCNT) {
						map[r][c] = 0;
						home[homeCNT - 1] = dfsHome(r, c,1);
						homeCNT--;
					}
				}
			}
		}
		System.out.println(home.length-1);
		Arrays.sort(home);
		for(int r=1;r<home.length;r++) {
			System.out.println(home[r]);
		}

	}

	private static int dfsHome(int r, int c, int cnt) {
		int nr, nc;
		for (int d = 0; d < dirs.length; d++) {
			nr = r + dirs[d][0];
			nc = c + dirs[d][1];
			if (isIn(nr, nc) && map[nr][nc] == homeCNT) {
				map[nr][nc] = 0;
				cnt = dfsHome(nr, nc, cnt + 1);
			}
		}
		return cnt;
	}

	private static void dfs(int r, int c) {
		int nr, nc;
		for (int d = 0; d < dirs.length; d++) {
			nr = r + dirs[d][0];
			nc = c + dirs[d][1];
			if (isIn(nr, nc) && map[nr][nc] == 1) {
				map[nr][nc] = homeCNT;
				dfs(nr, nc);
			}
		}
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
