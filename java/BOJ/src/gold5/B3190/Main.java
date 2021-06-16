package gold5.B3190;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Snake {
		int r;
		int c;

		public Snake(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	static int N, K;
	static int[][] MAP;
	static int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // 상우하좌
	static Deque<Snake> snake = new LinkedList<>();

	public static void main(String[] args) {

		initMap();
		int answer = 0;
		int d = 1;
		while (!snake.isEmpty()) {
			if (pq.isEmpty()) {
				answer++;
				Snake s = snake.peekFirst();
				int nr = s.r + dirs[d][0];
				int nc = s.c + dirs[d][1];
				if (isIn(nr, nc) && MAP[nr][nc] != 2) { // 갈 수 있음
					snake.addFirst(new Snake(nr, nc));
					if (MAP[nr][nc] == 0) { // 사과가 아니면 꼬리 지워야돼
						Snake temp = snake.pollLast();
						MAP[temp.r][temp.c] = 0;
					}
					MAP[nr][nc] = 2;
				} else {
					System.out.println(answer);
					return;
				}
				continue;
			}
			Order o = pq.poll();
			while (answer < o.time) {
				answer++;
				Snake s = snake.peekFirst();
				int nr = s.r + dirs[d][0];
				int nc = s.c + dirs[d][1];
				if (isIn(nr, nc) && MAP[nr][nc] != 2) { // 갈 수 있음
					snake.addFirst(new Snake(nr, nc));
					if (MAP[nr][nc] == 0) { // 사과가 아니면 꼬리 지워야돼
						Snake temp = snake.pollLast();
						MAP[temp.r][temp.c] = 0;
					}
					MAP[nr][nc] = 2;
				} else {
					System.out.println(answer);
					return;
				}
			}
			switch (o.c) {
			case 'L':
				d = d == 0 ? 3 : d - 1;
				break;
			case 'D':
				d = (d + 1) % 4;
				break;
			}

		}

		System.out.println(answer);

	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

	static class Order implements Comparable<Order> {
		int time;
		char c;

		public Order(int time, char c) {
			this.time = time;
			this.c = c;
		}

		@Override
		public int compareTo(Order o) {
			return Integer.compare(this.time, o.time); // 시간 순 오름차순
		}

	}

	static PriorityQueue<Order> pq = new PriorityQueue<>();

	private static void initMap() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		try {
			N = Integer.parseInt(br.readLine());
			MAP = new int[N][N];
			K = Integer.parseInt(br.readLine());
			for (int k = 0; k < K; k++) {
				str = new StringTokenizer(br.readLine(), " ");
				int r = Integer.parseInt(str.nextToken()) - 1;
				int c = Integer.parseInt(str.nextToken()) - 1;
				MAP[r][c] = 1;
			}
			int L = Integer.parseInt(br.readLine());
			for (int l = 0; l < L; l++) {
				str = new StringTokenizer(br.readLine(), " ");
				int time = Integer.parseInt(str.nextToken());
				char c = str.nextToken().charAt(0);
				pq.offer(new Order(time, c));
			}

		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

		snake.add(new Snake(0, 0));
		MAP[0][0] = 2;
	}

}
