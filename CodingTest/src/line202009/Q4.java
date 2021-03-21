package line202009;

import java.util.Arrays;

public class Q4 {

	public static void main(String[] args) {

		int[][] maze1 = { { 0, 1, 0, 1 }, { 0, 1, 0, 0 }, { 0, 0, 0, 0 }, { 1, 0, 1, 0 } };
		System.out.println(solution(maze1));
//		for (int[] ma : map) {
//			System.out.println(Arrays.toString(ma));
//		}
//		System.out.println("--------------------------------------------------");

		int[][] maze2 = { { 0, 1, 0, 0, 0, 0 }, { 0, 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 1, 0 }, { 0, 1, 1, 1, 1, 0 },
				{ 0, 1, 0, 0, 0, 0 }, { 0, 0, 0, 1, 1, 0 } };
		System.out.println(solution(maze2));

		int[][] maze3 = { { 0, 1, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 1, 0 },
				{ 0, 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1, 0 } };
		System.out.println(solution(maze3));

		int[][] maze4 = { { 0, 0, 0, 0, 0, 0 }, { 1, 1, 1, 0, 1, 1 }, { 0, 0, 0, 0, 0, 0 }, { 1, 0, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0, 0 }, { 1, 1, 0, 1, 1, 0 } };
		System.out.println(solution(maze4));

	}

	static int[][] dirsP = { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };
	static int[][] dirsH = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int[][] map;

	public static int solution(int[][] maze) {
		int result = 0;
		int N = maze.length;
		map = new int[N + 2][N + 2];
		for (int[] m : map) {
			Arrays.fill(m, 1); // 시작은 벽으로 감싸놓고
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = maze[i - 1][j - 1];
			}
		}
		int d = 0, x = 1, y = 1;
		map[x][y] += 2;
		while (x != N || y != N) {

			int hx = x + dirsH[d][0];
			int hy = y + dirsH[d][1];
			int nx = x + dirsP[d][0];
			int ny = y + dirsP[d][1];

			if (map[hx][hy] == 1) {
				if (map[nx][ny] != 1) {
					x = nx;
					y = ny;
					map[nx][ny] += 2;
					result++;
				} else {
					d = d + 1 > 3 ? 0 : d + 1;
				}
			} else { // map[hx][hy]==0
				x = hx;
				y = hy;
				map[x][y] += 2;
				result++;
				d = d - 1 < 0 ? 3 : d - 1;
			}
		}

		return result;
	}

}
