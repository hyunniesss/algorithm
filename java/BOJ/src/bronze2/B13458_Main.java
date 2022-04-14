package bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B13458_Main {

	static class Input {
		int N; // 시험장 수
		int[] aplcnt; // 응시자수
		int B; // 총감독관
		int C; // 부감독관

		public Input(int n, int[] aplcnt, int b, int c) {
			N = n;
			this.aplcnt = aplcnt;
			B = b;
			C = c;
		}
	}

	public static void main(String[] args) {

		Input input = initInput();
		long answer = input.N;
		for (int i = 0; i < input.N; i++) {
			if (input.aplcnt[i] > 0) {
				answer += (input.aplcnt[i] / input.C) + ((input.aplcnt[i] % input.C) == 0 ? 0 : 1);
			}
		}
		System.out.println(answer);
	}

	private static Input initInput() {

		Input in = null;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		try {
			int n = Integer.parseInt(br.readLine());
			int[] aplcnt = new int[n];
			str = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n; i++) {
				aplcnt[i] = Integer.parseInt(str.nextToken());
			}
			str = new StringTokenizer(br.readLine(), " ");
			int b = Integer.parseInt(str.nextToken());
			int c = Integer.parseInt(str.nextToken());
			for (int i = 0; i < n; i++) {
				aplcnt[i] -= b;
			}
			in = new Input(n, aplcnt, b, c);
		} catch (NumberFormatException | IOException e) {
		}

		return in;
	}

}
