package bronze4;

import java.util.Scanner;

public class B2420_Main {

	static class Input {
		long n;
		long m;

		public Input(long n, long m) {
			this.n = n;
			this.m = m;
		}

		public long getDiff() {
			return Math.abs(n - m);
		}

	}

	public static void main(String[] args) {
		// |N-M|
		// 입력
		Input input = getInput();
		System.out.println(input.getDiff());
	}

	private static Input getInput() {
		int n, m;
		try (Scanner sc = new Scanner(System.in)) {
			n = sc.nextInt();
			m = sc.nextInt();
		}

		return new Input(n, m);
	}

}
