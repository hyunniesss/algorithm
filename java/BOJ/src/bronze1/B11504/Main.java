package bronze1.B11504;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, arr[];
	static long X, Y;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int answer = 0;
			str = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(str.nextToken());
			M = Integer.parseInt(str.nextToken());
			X = 0L;
			Y = 0L;

			str = new StringTokenizer(br.readLine(), " ");
			while (str.hasMoreTokens()) {
				X *= 10;
				X += Integer.parseInt(str.nextToken());
			}
			str = new StringTokenizer(br.readLine(), " ");
			while (str.hasMoreTokens()) {
				Y *= 10;
				Y += Integer.parseInt(str.nextToken());
			}

			arr = new int[N];
			str = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(str.nextToken());
			}
			int[] brr = new int[M];
			for (int i = 0; i < N; i++) { // 시작 위치
				int j = i;
				long temp = 0L;
				for (int m = 0; m < M; m++) {
					temp *= 10;
					temp += arr[(j + m) % N];
				}
				if (X <= temp && temp <= Y) {
					answer++;
				}
			}

			System.out.println(answer);

		}

	}

}
