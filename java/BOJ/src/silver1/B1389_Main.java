package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1389_Main {

	static int[][] MAP;
	static int V;

	public static void main(String[] args) {

		initMap();

		floydWarshall();

	}

	private static void floydWarshall() {

		for (int k = 1; k <= V; k++) {
			for (int i = 1; i <= V; i++) {
				if (i == k) {
					continue;
				}
				for (int j = 1; j <= V; j++) {
					if (i == j || k == j || MAP[i][k] == INF || MAP[k][j] == INF) {
						continue;
					}
					MAP[i][j] = Math.min(MAP[i][j], MAP[i][k] + MAP[k][j]);
				}
			}
		}
		int maxIdx = 0, maxSum = Integer.MAX_VALUE;

		for (int i = 1; i <= V; i++) {

			int sum = sum(i);
			if (maxSum > sum) {
				maxIdx = i;
				maxSum = sum;
			}
		}

		System.out.println(maxIdx);

	}

	private static int sum(int i) {
		int sum = 0;
		for (int j = 1; j <= V; j++) {
			sum += MAP[i][j];
		}
		return sum;
	}

	static final int INF = Integer.MAX_VALUE;

	private static void initMap() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;

		try {
			str = new StringTokenizer(br.readLine(), " ");

			V = Integer.parseInt(str.nextToken());
			int E = Integer.parseInt(str.nextToken());

			MAP = new int[V + 1][V + 1];

			for (int i = 1; i <= V; i++) {
				Arrays.fill(MAP[i], INF);
				MAP[i][i] = 0;
			}

			for (int i = 0; i < E; i++) {
				str = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(str.nextToken());
				int b = Integer.parseInt(str.nextToken());
				MAP[a][b] = 1;
				MAP[b][a] = 1;
			}

		} catch (IOException e) {
		}

	}

}
