package gold5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B14053_Main {

	static int R, C;
	static int answer;
	static int[][] MAP;
	static int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

	static class Robot {
		int r;
		int c;
		int d;

		public Robot(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(str.nextToken());
		C = Integer.parseInt(str.nextToken());
		MAP = new int[R][C];

		str = new StringTokenizer(br.readLine());
		int r, c, d;
		r = Integer.parseInt(str.nextToken());
		c = Integer.parseInt(str.nextToken());
		d = Integer.parseInt(str.nextToken());
		d = d == 0 || d == 2 ? d : d == 1 ? 3 : 1;
		Robot robot = new Robot(r, c, d);

		for (int x = 0; x < R; x++) {
			str = new StringTokenizer(br.readLine());
			for (int y = 0; y < C; y++) {
				MAP[x][y] = Integer.parseInt(str.nextToken());
			}
		}
		int nr, nc, nd;
		while (true) {

//			1. 현재 위치 청소
			if (MAP[robot.r][robot.c] == 0) {
				cleanMap(robot);
			}
//			2-1,2. 왼쪽 방향 청소할 수 있는가
			boolean flag = false;
			for (int i = 1; i < 5; i++) {
				nd = (robot.d + i) % 4;
				nr = robot.r + dirs[nd][0];
				nc = robot.c + dirs[nd][1];
				if (isIn(nr, nc) && MAP[nr][nc] == 0) {
					robot = new Robot(nr, nc, nd);
					flag = true;
					break;
				}
			}
			if (flag) {
				continue;
			}
			nr = robot.r - dirs[robot.d][0];
			nc = robot.c - dirs[robot.d][1];
			if (isIn(nr, nc)) {
				robot = new Robot(nr, nc, robot.d);
				continue;
			}
			break;
		}

		for (int x = 0; x < R; x++) {
			for (int y = 0; y < C; y++) {
				if (MAP[x][y] == 2) {
					answer++;
				}
			}
		}

		System.out.println(answer);

	}

	private static void cleanMap(Robot robot) {
		MAP[robot.r][robot.c] = 2;
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C && MAP[r][c] != 1;
	}

}
