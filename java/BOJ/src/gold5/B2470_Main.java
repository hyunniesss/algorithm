package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B2470_Main {

	static class Liq {
		int x;
		int y;
		int result;

		public Liq(int x, int y) {
			this.x = Math.min(x, y);
			this.y = Math.max(x, y);
			result = Math.abs(x + y);
		}

		@Override
		public String toString() {
			return x + " " + y;
		}

	}

	static int N, arr[];

	public static void main(String[] args) {

		initInput();
		Arrays.sort(arr);
		Liq liq = new Liq(arr[0], arr[1]);

		for (int f = 0; f < N - 1; f++) {
			int r = N - 1;
			while (f < r && Math.abs(arr[f] + arr[r]) > Math.abs(arr[f] + arr[r - 1])) {
				if (liq.result > Math.abs(arr[f] + arr[r - 1])) {
					liq = new Liq(arr[f], arr[r]);
				}
				r--;
			}
		}

		System.out.println(liq.toString());

	}

	private static void initInput() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;

		try {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			str = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(str.nextToken());
			}
		} catch (NumberFormatException | IOException e) {
		}

	}

}
