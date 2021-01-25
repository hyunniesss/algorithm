package silver1.B1389;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_fail {

	static int N, M;
	static int sum;
	static boolean[][] map;
	static boolean[][] check;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new boolean[N][N];

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			if (map[a][b]) {
				continue;
			} else {
				map[a][b] = true;
				map[b][a] = true;
			}
		} // end input

		int[][] friends = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) { // i에서 j까지 가는데 걸리는 시간
				sum = Integer.MAX_VALUE;
				check = new boolean[N][N];
				dfs(i, j, 0);
				friends[i][j] = sum;
				friends[j][i] = sum;
			}
		}
		int[] min = new int[2]; // 0에는 인덱스, 1에는 계산결과
		Arrays.fill(min, Integer.MAX_VALUE);
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < N; j++) {
				sum += friends[i][j];
			}
			if (min[1] > sum) {
				min[0] = i;
				min[1] = sum;
			}
		}
		
		System.out.println(min[0]+1);

	}

	private static void dfs(int cur, int end, int cnt) {
		if (cnt >= sum) {
			return;
		}
		if (cur == end) {
			sum = Math.min(sum, cnt);
			return;
		}

		for (int k = 0; k < N; k++) {
			if (map[cur][k] && !check[cur][k]) {
				check[cur][k] = true;
				dfs(k, end, cnt + 1);
			}
		}
	}

}
