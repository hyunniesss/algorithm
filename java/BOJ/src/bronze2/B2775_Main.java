package bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2775_Main {

	static int K, N;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) { // K 층의 N호
			K = Integer.parseInt(br.readLine());
			N = Integer.parseInt(br.readLine());
			int[][] map = new int[K + 1][N + 1];
			for (int i = 1; i <= N; i++) {
				map[0][i] = i;
			}
			for (int k = 1; k <= K; k++) {
				for (int n = 1; n <= N; n++) { // k층 n호
					for (int i = 1; i <= n; i++) {
						map[k][n] += map[k - 1][i];
					}
				}
			}

			System.out.println(map[K][N]);

		}
	}

}
