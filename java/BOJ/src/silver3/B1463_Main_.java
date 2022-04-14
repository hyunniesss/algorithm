package silver3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1463_Main_ {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int N = sc.nextInt();
			int count = makeOne(N);
			System.out.println(count);
		}
	}

	static class Number {
		int n;
		int cnt;

		public Number(int n, int cnt) {
			this.n = n;
			this.cnt = cnt;
		}
	}

	private static int makeOne(int n) {
		final int ONE = 1, TWO = 2, THREE = 3;
		Queue<Number> queue = new LinkedList<>();
		queue.offer(new Number(n, 0));
		while (!queue.isEmpty()) {
			Number now = queue.poll();
			if (now.n % THREE == 0 && now.n / THREE > 0) {
				queue.offer(new Number(now.n / THREE, now.cnt + 1));
			}
			if (now.n % TWO == 0 && now.n / TWO > 0) {
				queue.offer(new Number(now.n / TWO, now.cnt + 1));
			}
			if (now.n - 1 > 0) {
				queue.offer(new Number(now.n - 1, now.cnt + 1));
			}
		}
		return -1;
	}

}
