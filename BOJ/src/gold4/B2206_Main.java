package gold4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2206_Main {

	static int R, C;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static char[][] map;
	static boolean[][][] check;
	static int answer = -1;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(str.nextToken());
		C = Integer.parseInt(str.nextToken());
		map = new char[R][C];
		check = new boolean[R][C][2];
		for (int r = 0; r < R; r++) {
			map[r] = br.readLine().toCharArray();
		}
		if (R == 1 && C == 1) {
			System.out.println(1);
			return;
		}
		bfs();
	}

	private static void bfs() {

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { 0, 0, 1, 0 }); // r, c, cnt, boolean
		map[0][0] -= 2;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			if (answer > -1) {
				break;
			}
			int nr, nc;
			for (int d = 0; d < 4; d++) {
				nr = cur[0] + dirs[d][0];
				nc = cur[1] + dirs[d][1];
				if (nr == R - 1 && nc == C - 1) {
					answer = cur[2] + 1;
					break;
				} else if (isIn(nr, nc)) {
					if (map[nr][nc] == '0' && !check[nr][nc][cur[3]]) {
						queue.offer(new int[] { nr, nc, cur[2] + 1, cur[3] }); // 0이면 고
//						map[nr][nc] -= 2;	// 방문처리
						check[nr][nc][cur[3]] = true;
					} else if (map[nr][nc] == '1' && cur[3] == 0 && !check[nr][nc][cur[3]]) { // 1이어도 깬 적 없으면 깨고 ㄱ
						queue.offer(new int[] { nr, nc, cur[2] + 1, 1 });
//						map[nr][nc] -= 2;	// 방문처리
						check[nr][nc][1] = true;
					}
				}
			}
		}
//		for (int r = 0; r < R; r++) {
//			System.out.println(Arrays.toString(map[r]));
//		}

		System.out.println(answer);

	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

}
