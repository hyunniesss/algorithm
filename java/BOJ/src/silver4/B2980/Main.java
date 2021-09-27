package silver4.B2980;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static Point[] check;
	static boolean[] canGo;
	static int N, L;

	static class Point {
		int r;
		int g;

		public Point(int r, int g) {
			this.r = r;
			this.g = g;
		}
	}

	public static void main(String[] args) {

		initMap();

		int answer = 0;
		for (int i = 0; i <= L; i++) {

			answer++;
			for (int j = i; j <= L; j++) {
				if (check[j] != null) {
					int temp = check[j].g + check[j].r;
					if (answer % (temp) < check[j].r) {
						canGo[j] = false;
					} else {
						canGo[j] = true;
					}
				}
			}

			if (canGo[i]) {
				continue;
			} else {
				i--;
			}

		}

		System.out.println(answer);

	}

	private static void initMap() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;

		try {
			str = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(str.nextToken());
			L = Integer.parseInt(str.nextToken());

			check = new Point[L + 1];
			canGo = new boolean[L + 1];
			Arrays.fill(canGo, true);

			for (int i = 0; i < N; i++) {
				str = new StringTokenizer(br.readLine(), " ");
				int d = Integer.parseInt(str.nextToken());
				int r = Integer.parseInt(str.nextToken());
				int g = Integer.parseInt(str.nextToken());
				check[d] = new Point(r, g);
				canGo[d] = false;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
