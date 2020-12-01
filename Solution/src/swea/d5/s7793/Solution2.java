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

public class Solution2 {
	// 출력을 모아서
	static StringBuilder sb = new StringBuilder();
	// 사방 탐색
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static int T, R, C, answer;
	static char[][] map;
	static Queue<Point> points;

	static class Point {
		int row, col, depth; // 행, 열, 깊이(단계)
		boolean isDevil;

		public Point(int row, int col, int depth, boolean isDevil) {
			this.row = row;
			this.col = col;
			this.depth = depth;
			this.isDevil = isDevil;
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
			answer = Integer.MAX_VALUE;
			points = new LinkedList<>();
			Point player = null;
			for (int r = 0; r < R; r++) {
				map[r] = br.readLine().toCharArray();
				for (int c = 0; c < C; c++) {
					if (map[r][c] == '*') {
						points.offer(new Point(r, c, 0, true));
					} else if (map[r][c] == 'S') {
						player = new Point(r, c, 0, false);
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
			outer: while (!points.isEmpty()) {
				Point front = points.poll();

				for (int d = 0; d < dirs.length; d++) {
					int nr = front.row + dirs[d][0];
					int nc = front.col + dirs[d][1];
					if (isIn(nr, nc)) { // 범위에 있다면 수연이는 .으로 이동, D를 만나면 끝
						if (front.isDevil) {
							if (map[nr][nc] == '.' || map[nr][nc] == 'S') {
								// 지도의 상태를 변경하여 방문처리
								map[nr][nc] = '*';
								// 쿠에 새로 들어가긴 하지만 빠지지는 않는다.
								points.offer(new Point(nr, nc, front.depth + 1, true));
							}
						} else {
							if (map[nr][nc] == 'D') {
								answer = front.depth + 1;
								break outer;
							} else if (map[nr][nc] == '.') {
								// 지도의 상태를 변경하여 방문처리
								map[nr][nc] = 'S';
								// 쿠에 새로 들어가긴 하지만 빠지지는 않는다.
								points.offer(new Point(nr, nc, front.depth + 1, false));
							}
						}
					}
				}
			}
			sb.append(answer == Integer.MAX_VALUE ? "GAME OVER" : answer);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

	static String src = "2\r\n" + "5 3\r\n" + "D*S\r\n" + ".X.\r\n" + ".X.\r\n" + ".X.\r\n" + "...\r\n" + "5 3\r\n"
			+ "D*S\r\n" + "...\r\n" + ".X.\r\n" + ".X.\r\n" + "...\r\n";

}
