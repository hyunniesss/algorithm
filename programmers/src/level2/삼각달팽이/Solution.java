package level2.삼각달팽이;

import java.util.Arrays;

public class Solution {

	public int[] solution(int n) {
		int N = (n * (n + 1)) / 2;
		int[][] answer = new int[n][n];
		int[] result = new int[N];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				answer[i][j] = -1; // 값을 넣을 공간
			}
		}

		int i = 0, j = 0, k = 1;
		answer[i][j] = k;

		while (k < N) {
			// 1. 세로행 담기
			while (k < N && i + 1 < n && answer[i + 1][j] == -1) {
				answer[++i][j] = ++k;
			}

			// 2. 가로행 담기
			while (k < N && j + 1 < n && answer[i][j + 1] == -1) {
				answer[i][++j] = ++k;
			}

			// 3. 대각선 담기
			while (k < N && j - 1 >= 0 && i - 1 >= 0 && answer[i - 1][j - 1] == -1) {
				answer[--i][--j] = ++k;
			}
		}
		k = 0;
		for (i = 0; i < n; i++) {
			for (j = 0; j <= i; j++) {
				result[k++] = answer[i][j];
			}
		}

		return result;

	}

}
