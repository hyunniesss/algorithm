package swea.d5.s7793;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author hyunhee 
 * - 안전 지역으로 가기 위한 최소 시간 : BFS 
 * - 악마와 수연이가 각각 별도의 Queue에서 동작 
 * - 악마  * : 1초마다 사방으로 퍼져나간다. '.','S'를 대상 
 * - 수연 S : 1초마다 사방탐색으로 이동, '.'을 대상으로 이동, 'D'를 만나면 종료 
 * - 수연이 없어지면 종료
 */

public class Solution1 {
	// 출력을 모아서
	static StringBuilder sb = new StringBuilder();
	// 사방 탐색
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static int T, R, C;
	static char[][] map;
	static Queue<Point> devil, player;

	static class Point {
		int row, col, depth; // 행, 열, 깊이(단계)

		public Point(int row, int col, int depth) {
			this.row = row;
			this.col = col;
			this.depth = depth;
		}

		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + ", depth=" + depth + "]";
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src)); // 제출 시 주석

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			StringTokenizer tokens = new StringTokenizer(br.readLine());
			R = Integer.parseInt(tokens.nextToken()); // N, M(2 ≤ N, M ≤ 50)
			C = Integer.parseInt(tokens.nextToken());

			map = new char[R][C];
			devil = new LinkedList<>();
			player = new LinkedList<>();
			for (int r = 0; r < R; r++) {
				map[r] = br.readLine().toCharArray();
				for (int c = 0; c < C; c++) {
					if (map[r][c] == '*') {
						devil.offer(new Point(r, c, 0));
					} else if (map[r][c] == 'S') {
						player.offer(new Point(r, c, 0));
					}
				}
			}

//			for(char[] row : map) {
//				System.out.println(Arrays.toString(row));
//			}
//			System.out.println(player);
//			System.out.println(devil);

			// 이제 탐험 시작
			// 끝나는 시점 : 모든 수연이 소멸할 때 까지 OR 수연이가 여신에게 도달할 때까지
			while (true) {
				// 1. 만약 player가 없다면 GAME OVER
				if (player.size() == 0) {
					sb.append("GAME OVER");
					break;
				}
				// 2. devil이 1초 동작 -> .,S 만나면 오염
				bfsDevil();
				// 3. player가 동작 -> .으로 이동, D 만나면 종료
				int result = bfsPlayer();
				if(result!=-1) {
					sb.append(result);
					break;
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static int bfsPlayer() { // 여신을 만나면 depth값 반환
		int size = player.size();

		while (size-- > 0) {
			Point front = player.poll();
			// 자식 탐색 - 사방 탐색
			for (int d = 0; d < dirs.length; d++) {
				int nr = front.row + dirs[d][0];
				int nc = front.col + dirs[d][1];
				if (isIn(nr, nc)) { // 범위에 있다면 수연이는 .으로 이동, D를 만나면 끝
					if (map[nr][nc] == 'D') {
						return front.depth + 1;
					} else if (map[nr][nc] == '.') {
						// 지도의 상태를 변경하여 방문처리
						map[nr][nc] = 'S';
						// 쿠에 새로 들어가긴 하지만 빠지지는 않는다.
						player.offer(new Point(nr, nc, front.depth + 1));
					}
				}
			}
		}
		return -1;
	}

	// 현재 Queue에 있는 놈까지만. 새로운 녀석은 그냥 담아둘 뿐.
	private static void bfsDevil() {
		int size = devil.size();

		while (size-- > 0) {
			Point front = devil.poll();
			// 자식 탐색 - 사방 탐색
			for (int d = 0; d < dirs.length; d++) {
				int nr = front.row + dirs[d][0];
				int nc = front.col + dirs[d][1];
				if (isIn(nr, nc)) { // 범위에 있다면 악마는 .,S를 대상으로 이동
					if (map[nr][nc] == '.' || map[nr][nc] == 'S') {
						// 지도의 상태를 변경하여 방문처리
						map[nr][nc] = '*';
						// 쿠에 새로 들어가긴 하지만 빠지지는 않는다.
						devil.offer(new Point(nr, nc, front.depth + 1));
					}
				}
			}
		}
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

	static String src = "2\r\n" + "5 3\r\n" + "D*S\r\n" + ".X.\r\n" + ".X.\r\n" + ".X.\r\n" + "...\r\n" + "5 3\r\n"
			+ "D*S\r\n" + "...\r\n" + ".X.\r\n" + ".X.\r\n" + "...\r\n";

}
