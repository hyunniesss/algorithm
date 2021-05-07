package level3.경주로건설;

import java.util.Arrays;

public class Solution {

	int N;
	final int MAX = 375000;
	int answer = MAX;
//	boolean[][] check;
	int[][][][] dp;

	public int solution(int[][] board) {

		N = board.length;
//		check = new boolean[N][N];
//		check[0][0] = true;
		dp = new int[N][N][N][N];
		for (int[][][] a : dp) {
			for (int[][] b : a) {
				for (int[] c : b) {
					Arrays.fill(c, MAX);
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dp[i][j][0][0] = 0;
			}
		}
		for (int d = 0; d < dirs.length; d++) {
			dfs(0, 0, d, 0, board);
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				answer = Math.min(dp[i][j][N - 1][N - 1], answer);
			}
		}
		return answer;
	}

	int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	private void dfs(int r, int c, int d, int sum, int[][] board) {
		if (r == N - 1 && c == N - 1) {
//			answer = Math.min(answer, sum);
			return;
		}

		int nr, nc;
		for (int di = 0; di < dirs.length; di++) {
			nr = r + dirs[di][0];
			nc = c + dirs[di][1];
			if (canGo(nr, nc) && board[nr][nc] == 0) {
//				check[nr][nc] = true;
				if (d == di) {
//					if (answer > sum + 100) {
					if (dp[r][c][nr][nc] > sum + 100) {
						dp[r][c][nr][nc] = sum + 100;
						dfs(nr, nc, di, sum + 100, board);
					}
				} else {
//					if (answer > sum + 600) {
					if (dp[r][c][nr][nc] > sum + 600) {
						dp[r][c][nr][nc] = sum + 600;
						dfs(nr, nc, di, sum + 600, board);
					}
				}
//				check[nr][nc] = false;
			}
		}

	}

	private boolean canGo(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
