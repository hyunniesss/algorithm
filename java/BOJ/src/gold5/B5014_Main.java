package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B5014_Main {

	static int F, S, G, U, D;
	static int answer;

	public static void main(String[] args) {

		initGame();
		int answer = bfs();

		System.out.println(answer == -1 ? "use the stairs" : answer);
	}

	private static int bfs() {

		boolean[] check = new boolean[F + 1];
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { S, 0 });
		check[S] = true;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			if (cur[0] == G) {
				return cur[1];
			}
			int up = cur[0] + U;
			int down = cur[0] - D;
			if (up <= F && !check[up]) {
				check[up] = true;
				queue.offer(new int[] { up, cur[1] + 1 });
			}
			if (down >= 1 && !check[down]) {
				check[down] = true;
				queue.offer(new int[] { down, cur[1] + 1 });
			}
		}

		return -1;

	}

	private static void initGame() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str;
		try {
			str = new StringTokenizer(br.readLine(), " ");
			F = Integer.parseInt(str.nextToken());
			S = Integer.parseInt(str.nextToken());
			G = Integer.parseInt(str.nextToken());
			U = Integer.parseInt(str.nextToken());
			D = Integer.parseInt(str.nextToken());
		} catch (IOException e) {
		}

	}

}
