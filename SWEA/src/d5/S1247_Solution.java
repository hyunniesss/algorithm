package d5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S1247_Solution {

	static int T, N;

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static Point[] position;
	static int[] arr;
	static int min;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder result = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {

			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			position = new Point[N + 2]; // 0 : 회사, 1 : 집
			min = Integer.MAX_VALUE;

			StringTokenizer str = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < N + 2; i++) {

				int x = Integer.parseInt(str.nextToken());
				int y = Integer.parseInt(str.nextToken());
				position[i] = new Point(x, y);

			} // end input

			for (int i = 0; i < N; i++) {
				arr[i] = i + 2;
			}

			do {
				int curDist = 0;
				Point cur = position[0]; // 시작점

				for (int i = 0; i < N; i++) {
					Point home = position[arr[i]];
					int dist = Math.abs(home.x - cur.x) + Math.abs(home.y - cur.y);
					curDist += dist;
					cur = home;
				}

				curDist += (Math.abs(position[1].x - cur.x) + Math.abs(position[1].y - cur.y));
				min = Integer.min(min, curDist);
			} while (np());

			result.append("#").append(t).append(" ").append(min).append("\n");

		}

		bw.write(result.toString());
		bw.flush();

	}

	private static boolean np() {

		// 1. 꼭지점 찾기(i)
		int i = N - 1;
		while (i > 0 && arr[i - 1] > arr[i]) {
			i--;
		}
		if (i == 0) {
			return false;
		}

		// 2. 교환할 j 찾기
		int j = N - 1;
		while (arr[i - 1] >= arr[j]) {
			j--;
		}

		// 3. i-1 j 교환
		int temp = arr[i - 1];
		arr[i - 1] = arr[j];
		arr[j] = temp;

		// 4. swap
		int k = N - 1;
		while (i < k) {
			temp = arr[i];
			arr[i] = arr[k];
			arr[k] = temp;
			i++;
			k--;
		}

		return true;
	}

}
