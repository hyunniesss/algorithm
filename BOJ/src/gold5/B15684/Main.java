package gold5.B15684;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, H;
	static boolean[][] map;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		H = Integer.parseInt(str.nextToken());

		map = new boolean[N][H];
		for (int m = 0; m < M; m++) {
			str = new StringTokenizer(br.readLine(), " ");
			int h = Integer.parseInt(str.nextToken()) - 1;
			int b = Integer.parseInt(str.nextToken()) - 1;
			map[b][h] = true;
		}
		int cnt = 0;
		while (true) {
			if (combi(0, cnt, 0)) {
				break;
			}
			cnt++;
			if (cnt > 3) {
				cnt = -1;
				break;
			}
		}

		System.out.println(cnt);

	}

	private static boolean combi(int cnt, int R, int cur) {
		if (cnt == R) {
			return check();
		}

		for (int n = cur; n < N - 1; n++) {
			for (int h = 0; h < H; h++) {
				if (!map[n][h]) {
					map[n][h] = true;
					if (combi(cnt + 1, R, n)) {
						return true;
					}
					map[n][h] = false;
				}
			}
		}

		return false;
	}

	private static boolean check() {

		for (int i = 0; i < N; i++) { // 얘가 시작점
			int n = i;
			for (int h = 0; h < H; h++) { // 각 높이에서 n의 위치 변경
				if (map[n][h]) {
					n++;
				} else if (n > 0 && map[n - 1][h]) {
					n--;
				}
			}
			if (n != i) {
				return false;
			}
		}

		return true;

	}

}
