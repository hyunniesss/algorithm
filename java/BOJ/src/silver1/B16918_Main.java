package silver1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16918_Main {

	static int R, C;
	static final int TIME = 3;
	static char[][] map;
	static int[][] bomb;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) {
		int N = initInput();
		getBomb(N);
		printMap(map);

	}

	private static void printMap(char[][] map) {
		StringBuilder sb = new StringBuilder();
		for (char[] c : map) {
			for (char d : c) {
				sb.append(d);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void getBomb(int limit) {
		int now = 1;

		while (now < limit) {
//		2. 폭탄이 설치되지 않은 모든 곳에 폭탄 설치
			installBomb(++now); // 2초일 때 설치, 4초일 때 설치, 6초일 때 설치
//		3. 터뜨리기 & 인접 4방 터뜨리기
			now++; // 3초, 5초, 7초
			if (now > limit) {
				break;
			}
			doBomb(now); // 폭발 (3초, 5초, 7초)
		}
	}

	private static void doBomb(int now) {
		Queue<int[]> queue = new LinkedList<>();
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (bomb[r][c] == now) {
					map[r][c] = '.';
					bomb[r][c] = 0;
					queue.offer(new int[] { r, c });
				}
			}
		}
//		4. 인접한 4방 터뜨리기
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int d = 0; d < dirs.length; d++) {
				int nr = cur[0] + dirs[d][0];
				int nc = cur[1] + dirs[d][1];
				if (isIn(nr, nc)) {
					map[nr][nc] = '.';
					bomb[nr][nc] = 0;
				}
			}
		}
	}

	private static void installBomb(int now) {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == '.') {
					map[r][c] = 'O';
					bomb[r][c] = now + TIME;
				}
			}
		}
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

	private static int initInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		int N = -1;
		try {
			str = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(str.nextToken());
			C = Integer.parseInt(str.nextToken());
			N = Integer.parseInt(str.nextToken());

			map = new char[R][C];
			bomb = new int[R][C];
			for (int r = 0; r < R; r++) {
				map[r] = br.readLine().toCharArray();
				for (int c = 0; c < C; c++) {
					if (map[r][c] == '.') {
						continue;
					}
					bomb[r][c] = TIME; // 3초에 터질 예정
				}
			}
		} catch (Exception e) {
		}

		return N;
	}

}
