package silver5;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class B1018_Main {

	static char[][] map;
	static int N, M;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		map = new char[N][M];
		for (int r = 0; r < N; r++) {
			map[r] = br.readLine().toCharArray();
		} // end input

		for (int r = 0; r <= N - 8; r++) {
			for (int c = 0; c <= M - 8; c++) { // r, c가 시작점
				int cnt = 0;
				for (int k = 0; k < 2; k++) { // B로 시작하냐 W로 시작하냐
					char scolor;
					cnt = 0;
					if (k % 2 == 0) {
						scolor = 'B';
					} else {
						scolor = 'W';
					}
					for (int i = 0; i < 8; i++) {
						char color = i % 2 == 0 ? scolor : (scolor == 'B' ? 'W' : 'B');
						for (int j = 0; j < 8; j++) {
							if (color != map[r + i][c + j]) {
								cnt++;
								if (cnt >= min) {
									break;
								}
							}
							color = color == 'B' ? 'W' : 'B';
						}
						if (cnt >= min) {
							break;
						}
					}
					min = Math.min(cnt, min);
				}
			}
		}

		System.out.println(min);

	}

}
