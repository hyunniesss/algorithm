package gold4.B16236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, foodCnt;
	static int[][] MAP;

	static class Point implements Comparable<Point> {
		int r;
		int c;
		int cnt;
		int depth;

		public Point(int r, int c, int cnt, int depth) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.depth = depth;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", cnt=" + cnt + ", depth=" + depth + "]";
		}

		@Override
		public int compareTo(Point o) {

			if (this.depth != o.depth) {
				return Integer.compare(this.depth, o.depth);
			}
			if (this.r != o.r) {
				return Integer.compare(this.r, o.r);
			}
			return Integer.compare(this.c, o.c);
		}

	}

	static Queue<Point> shark = new LinkedList<>();
	static PriorityQueue<Point> food = new PriorityQueue<>();

	public static void main(String[] args) {

		initMap();
		findShark();

		System.out.println(foodCnt == 0 ? 0 : bfs());

	}

	static boolean[][] check;

	private static int bfs() {
		int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		int answer = 0;

		while (!shark.isEmpty()) {
			int size = shark.size();
			while (size-- > 0) {
				// 1. 현재 깊이에서 먹이 찾기
				Point p = shark.poll();

				for (int d = 0; d < dirs.length; d++) {
					int nr = p.r + dirs[d][0];
					int nc = p.c + dirs[d][1];
					if (isIn(nr, nc)) {
						check[nr][nc] = true;
						if (MAP[nr][nc] == 0 || MAP[nr][nc] == p.cnt) {
							shark.offer(new Point(nr, nc, p.cnt, p.depth + 1));
						} else if (MAP[nr][nc] < p.cnt) { // 먹을 수 있는 애
							food.offer(new Point(nr, nc, p.cnt + 1, p.depth + 1));
						}
					}
				}

			}
//			System.out.println(Arrays.toString(shark.toArray()));
			answer++;
			if (food.isEmpty()) {
				continue;
			}
//			먹을 게 있으면 먹어
			eat();
			if (foodCnt == 0) {
				return answer;
			}
		}

		return answer;
	}

	private static void eat() {

		Point next = food.poll();
		MAP[next.r][next.c] = 0;
		next.depth = 0;
		shark.clear();
		food.clear();
		shark.offer(next);
		for (int i = 0; i < N; i++) {
			Arrays.fill(check[i], false);
		}
		check[next.r][next.c] = true;
		foodCnt--;

	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N && !check[r][c];
	}

	private static void findShark() {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (MAP[i][j] == 9) {
					shark.offer(new Point(i, j, 2, 0));
					check[i][j] = true;
					MAP[i][j] = 0;
				} else if (MAP[i][j] > 0) {
					foodCnt++;
				}
			}
		}

	}

	private static void initMap() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		try {
			N = Integer.parseInt(br.readLine());

			MAP = new int[N][N];
			check = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				str = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					MAP[i][j] = Integer.parseInt(str.nextToken());
				}
			}
		} catch (NumberFormatException | IOException e) {
		}

	}

}
