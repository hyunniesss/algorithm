package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1963_Main {

	static final int INF = 10000;
	static boolean[] isPrime = new boolean[INF];
	static boolean[] check = new boolean[INF];

	static int A, B;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;

		int T = Integer.parseInt(br.readLine());
		makePrime();

		for (int t = 0; t < T; t++) {
			str = new StringTokenizer(br.readLine(), " ");
			A = Integer.parseInt(str.nextToken());
			B = Integer.parseInt(str.nextToken());
			if (A == B) {
				System.out.println(0);
			} else {
				Arrays.fill(check, false);
				System.out.println(bfs());
			}
		}

	}

	private static void makePrime() {

		isPrime[0] = true;
		isPrime[1] = true;
		for (int i = 2; i <= Math.sqrt(INF); i++) {
			if (!isPrime[i]) {
				for (int j = i + i; j < INF; j += i) {
					isPrime[j] = true;
				}
			}
		}

	}

	private static int bfs() {

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { A, 0 });
		check[A] = true;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			if (cur[0] == B) {
				return cur[1];
			}

			for (int i = 1; i <= 1000; i *= 10) { // 자리수
				int next = cur[0];
				while (true) {
					next += i;
					if (!check(next, cur[0])) {
						break;
					}
					if (!isPrime[next] && !check[next]) {
						queue.offer(new int[] { next, cur[1] + 1 });
						check[next] = true;
					}
				}
			}

			for (int i = 1; i <= 1000; i *= 10) { // 자리수
				int next = cur[0];
				while (true) {
					next -= i;
					if (!check(next, cur[0])) {
						break;
					}
					if (!isPrime[next] && !check[next]) {
						queue.offer(new int[] { next, cur[1] + 1 });
						check[next] = true;
					}
				}
			}
		}

		return -1;
	}

	private static boolean check(int a, int b) {

		char[] tempA = (a + "").toCharArray();
		char[] tempB = (b + "").toCharArray();

		if (tempA.length != 4) {
			return false;
		}

		int count = 0;
		for (int i = 0; i < tempA.length; i++) {
			if (tempA[i] != tempB[i]) {
				count++;
			}
		}

		return count == 1;
	}

}
