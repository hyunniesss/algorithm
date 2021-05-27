package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16953_Main {

	static long A, B;
	static HashSet<Long> hs = new HashSet<>();

	public static void main(String[] args) {

		init();
		System.out.println(bfs(A));

	}

	private static long bfs(long start) {

		Queue<long[]> queue = new LinkedList<>(); // [0] : num, [1] : depth
		queue.offer(new long[] { start, 1L });
		hs.add(start);

		while (!queue.isEmpty()) {
			long[] cur = queue.poll();

			if (cur[0] == B) {
				return cur[1];
			}

			long next = cur[0] * 2;
			if (next <= B && !hs.contains(next)) {
				queue.offer(new long[] { next, cur[1] + 1 });
				hs.add(next);
			}

			next = cur[0] * 10 + 1;
			if (next <= B && !hs.contains(next)) {
				queue.offer(new long[] { next, cur[1] + 1 });
				hs.add(next);
			}

		}

		return -1;
	}

	private static void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		try {
			str = new StringTokenizer(br.readLine(), " ");
		} catch (IOException e) {
			e.printStackTrace();
		}
		A = Long.parseLong(str.nextToken());
		B = Long.parseLong(str.nextToken());
	}

}
