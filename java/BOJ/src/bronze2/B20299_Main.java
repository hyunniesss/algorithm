package bronze2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20299_Main {

	static class Input {
		int N;
		int K;
		int L;
		int[][] data; // [N][3]

		public Input(int n, int k, int l, int[][] data) {
			N = n;
			K = k;
			L = l;
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Input input = initInput();
		int answer = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.N; i++) { // N개의 팀
			boolean flag = true;
			int sum = 0;
			for (int j = 0; j < 3; j++) {
				if (input.data[i][j] < input.L) {
					flag = false;
					break;
				}
				sum += input.data[i][j];
			}
			if (flag && (sum >= input.K)) {
				answer++;
				for (int j = 0; j < 3; j++) {
					sb.append(input.data[i][j]).append(" ");
				}
			}
		}
		System.out.println(answer);
		System.out.println(sb.toString());
	}

	private static Input initInput() {
		Input input = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		try {
			str = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(str.nextToken());
			int k = Integer.parseInt(str.nextToken());
			int l = Integer.parseInt(str.nextToken());
			int[][] data = new int[n][3];
			for (int i = 0; i < n; i++) {
				str = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 3; j++) {
					data[i][j] = Integer.parseInt(str.nextToken());
				}
			}
			input = new Input(n, k, l, data);
		} catch (Exception e) {
		}
		return input;
	}
}
