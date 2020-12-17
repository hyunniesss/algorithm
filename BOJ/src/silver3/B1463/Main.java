package silver3.B1463;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dfs(N, 0);
		System.out.println(answer);
	}

	private static void dfs(int n, int cnt) {
		if (cnt >= answer) {
			return;
		}
		if (n == 1) {
			answer = Math.min(cnt, answer);
			return;
		}
		if (n % 3 == 0) {
			dfs(n / 3, cnt + 1);
		}
		if (n % 2 == 0) {
			dfs(n / 2, cnt + 1);
		}
		dfs(n - 1, cnt + 1);
	}

}
