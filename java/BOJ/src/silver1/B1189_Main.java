package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1189_Main {

	static int R, C, K;
	static char[][] map;

	static class Point {
		int r;
		int c;
		int flag;
		int depth;

		public Point(int r, int c, int flag, int depth) {
			this.r = r;
			this.c = c;
			this.flag = flag;
			this.depth = depth;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", flag=" + flag + ", depth=" + depth + "]";
		}

	}

	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) {

		initInput();
		int answer = goBFS(R - 1, 0); // 왼쪽 아래에서 시작, 도착지는 [0, C-1]
		System.out.println(answer);

	}

	private static int goBFS(int r, int c) {
		int answer = 0;
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(r, c, (1 << (r * C + c)), 1)); // 시작점	// 10
		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			if (cur.depth == K) {
				if (cur.r == 0 && cur.c == C - 1) {
					answer++;
				}
				continue;
			}
			int nr, nc, nFlag;
			for (int d = 0; d < dirs.length; d++) {
				nr = cur.r + dirs[d][0];
				nc = cur.c + dirs[d][1];
				nFlag = cur.flag | (1 << (nr * C + nc));
				if (isIn(nr, nc) && isChecked(cur.flag, nr, nc)) {
					queue.offer(new Point(nr, nc, nFlag, cur.depth + 1));
				}
			}
		}
		return answer;
	}

	private static boolean isChecked(int flag, int r, int c) {
		return (flag & (1 << (r * C + c))) == 0;
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C && map[r][c] == '.';
	}

	private static void initInput() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		try {
			str = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(str.nextToken());
			C = Integer.parseInt(str.nextToken());
			K = Integer.parseInt(str.nextToken());
			map = new char[R][C];
			for (int r = 0; r < R; r++) {
				map[r] = br.readLine().toCharArray();
			}
		} catch (IOException e) {
		}

	}

}
