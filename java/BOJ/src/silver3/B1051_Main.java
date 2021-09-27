package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1051_Main {

	static int R, C;
	static char[][] MAP;
	static int MAX = 1;

	public static void main(String[] args) {

		initMap();

		for (int r = 0; r < R; r++) {

			for (int c = 0; c < C; c++) { // 좌상 꼭지점
				int nr = r + 1, nc = c + 1;
				while (isIn(nr, nc)) {
					if (MAP[r][c] == MAP[nr][nc] && MAP[r][c] == MAP[r][nc] && MAP[r][c] == MAP[nr][c]) { // 네 꼭지점이 모두
																											// 같으면
						MAX = Math.max(count(r, c, nr + 1, nc + 1), MAX);
					}
					nr++;
					nc++;
				}
			}

		}

		System.out.println(MAX);

	}

	private static int count(int r1, int c1, int r2, int c2) {
		return (r2 - r1) * (c2 - c1);
	}

	private static boolean isIn(int r, int c) {

		return r >= 0 && r < R && c >= 0 && c < C;

	}

	private static void initMap() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;

		try {
			str = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(str.nextToken());
			C = Integer.parseInt(str.nextToken());
			MAP = new char[R][C];
			for (int i = 0; i < R; i++) {
				MAP[i] = br.readLine().toCharArray();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
