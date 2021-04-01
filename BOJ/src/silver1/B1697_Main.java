package silver1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author hyunhee 가장 빠른 시간
 *
 */
public class B1697_Main {

	static int N, K;
	static boolean[] check = new boolean[200000];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(str.nextToken()); // 수빈
		K = Integer.parseInt(str.nextToken()); // 동생
		bfs();
	}

	private static void bfs() {
		Queue<int[]> queue = new LinkedList<>(); // 위치, 이동횟수
		queue.offer(new int[] { N, 0 });
		check[N] = true;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			if (cur[0] == K) {
				System.out.println(cur[1]);
				return;
			}
			int next = cur[0] + cur[0];
			if (canGo(next)) {
				check[next] = true;
				queue.offer(new int[] { cur[0] + cur[0], cur[1] + 1 });
			}
			next = cur[0] + 1;
			if (canGo(next)) {
				check[next] = true;
				queue.offer(new int[] { cur[0] + 1, cur[1] + 1 });
			}
			next = cur[0] - 1;
			if (canGo(next)) {
				check[next] = true;
				queue.offer(new int[] { cur[0] - 1, cur[1] + 1 });
			}
		}

	}

	private static boolean canGo(int next) {
		return next >= 0 && next < check.length && !check[next];
	}

}
