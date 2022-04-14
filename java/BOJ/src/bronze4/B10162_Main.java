package bronze4;

import java.util.*;

public class B10162_Main {
	static int[] seconds = { 300, 60, 10 }; // 초단위

	public static void main(String[] args) {
		int T = initInput();
		String answer = bfs(T);
		System.out.println(answer);
	}

	static class Timer {
		int a;
		int b;
		int c;
		int time;

		public Timer(int a, int b, int c, int time) {
			this.a = a;
			this.b = b;
			this.c = c;
			this.time = time;
		}

		@Override
		public String toString() {
			return "Timer [a=" + a + ", b=" + b + ", c=" + c + ", time=" + time + "]";
		}

	}

	private static String bfs(int T) {
		boolean[] visited = new boolean[T + 1];
		Queue<Timer> queue = new LinkedList<>();
		queue.offer(new Timer(0, 0, 0, T));
		visited[T] = true;
		while (!queue.isEmpty()) {
			Timer now = queue.poll();
			if (now.time == 0) {
				return now.a + " " + now.b + " " + now.c;
			}
			int time = now.time - seconds[0];
			if (time >= 0 && !visited[time]) {
				queue.offer(new Timer(now.a + 1, now.b, now.c, time));
				visited[time] = true;
			}
			time = now.time - seconds[1];
			if (time >= 0 && !visited[time]) {
				queue.offer(new Timer(now.a, now.b + 1, now.c, time));
				visited[time] = true;
			}
			time = now.time - seconds[2];
			if (time >= 0 && !visited[time]) {
				queue.offer(new Timer(now.a, now.b, now.c + 1, time));
				visited[time] = true;
			}
		}
		return "-1";
	}

	private static int initInput() {
		int T = 0;
		try (Scanner sc = new Scanner(System.in)) {
			T = sc.nextInt();
		}
		return T;
	}
}
