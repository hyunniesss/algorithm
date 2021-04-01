package gold5.B5014;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//  (1 ≤ S, G ≤ F ≤ 1000000, 0 ≤ U, D ≤ 1000000) 
//F, S, G, U, D

public class Main {

	static boolean[] check;
	static int F, S, G, U, D;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		F = Integer.parseInt(str.nextToken());
		S = Integer.parseInt(str.nextToken());
		G = Integer.parseInt(str.nextToken());
		U = Integer.parseInt(str.nextToken());
		D = Integer.parseInt(str.nextToken());
		check = new boolean[F + 1];

		int answer = bfs(S);

		bw.write(answer == -1 ? "use the stairs" : answer + "");
		bw.flush();

	}

	private static int bfs(int start) {

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { start, 0 });
		check[start] = true;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			if (cur[0] == G) {
				return cur[1];
			}

			int next = cur[0] + U;
			if (check.length > next && !check[next]) {
				check[next] = true;
				queue.offer(new int[] { next, cur[1] + 1 });
			}
			next = cur[0] - D;
			if (1 <= next && !check[next]) {
				check[next] = true;
				queue.offer(new int[] { next, cur[1] + 1 });
			}
		}

		return -1;
	}

}
