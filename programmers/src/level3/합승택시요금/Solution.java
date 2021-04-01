package level3.합승택시요금;

import java.util.Arrays;

/**
 * 
 * @author hyunhee 무향 가중치 그래프 최소비용 s = 출발 지점, a = a의 도착지점, b = b의 도착지점, n = 정점
 *         개수, int[][] fares = [c][d] = f
 */
public class Solution {

	final int INF = Integer.MAX_VALUE;

	public int solution(int n, int s, int a, int b, int[][] fares) {

		int[][] key = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			Arrays.fill(key[i], INF);
			key[i][i] = 0;
		}

		for (int i = 0; i < fares.length; i++) {
			key[fares[i][0]][fares[i][1]] = fares[i][2];
			key[fares[i][1]][fares[i][0]] = fares[i][2];
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				if (i == k || key[i][k] == INF) {
					continue;
				}

				for (int j = 1; j <= n; j++) {
					if (j == k || j == i || key[k][j] == INF) {
						continue;
					}
					key[i][j] = Math.min(key[i][k] + key[k][j], key[i][j]);
				}
			}
		}

		int min = INF;
		for (int i = 1; i <= n; i++) {
			min = Math.min(min, key[s][i] + key[i][a] + key[i][b]);
		}
		
		return min;

	}

}
