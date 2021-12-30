package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1388_Main {

	static char[][] map;
	static int R, C;

	public static void main(String[] args) {
//		- 만나면 오른쪽 탐색 , | 만나면 아래로 탐색
		initInput();
		int count = 0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == '.') {
					continue;
				}
				dfs(r, c, map[r][c]);
				count++;
			}
		}
		System.out.println(count);
	}

	private static void dfs(int r, int c, char d) {
		int nr = r;
		int nc = c;
		map[r][c] = '.';
		if (d == '-') {
			nc++;
		} else {
			nr++;
		}
		if (canGo(nr, nc) && map[nr][nc] == d) {
			map[nr][nc] = '.';
			dfs(nr, nc, d);
		}
	}

	private static boolean canGo(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

	private static void initInput() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		try {
			str = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(str.nextToken());
			C = Integer.parseInt(str.nextToken());
			map = new char[R][C];
			for (int i = 0; i < R; i++) {
				map[i] = br.readLine().toCharArray();
			}
		} catch (IOException e) {
		}

	}

}
