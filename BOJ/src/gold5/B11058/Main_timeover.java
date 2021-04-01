package gold5.B11058;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_timeover {

	static int N;
	static int MAX = -1;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		dfs(0, "", "", "");

		System.out.println(MAX);

	}

	private static void dfs(int n, String answer, String temp, String all) {
		if (n == N) {
			MAX = Math.max(MAX, answer.toString().length());
			return;
		}

		// 1. 화면에 A 출력
		dfs(n + 1, answer + "A", temp, all);
		// 2. 화면 전체 선택
		if (answer.length() >= 3) {
			dfs(n + 1, answer, temp, answer);
		}
		// 3. 복사
		if (all.length() > 0) {
			dfs(n + 1, answer, all, "");
		}
		// 4. 붙여넣기
		if (temp.length() > 0) {
			dfs(n + 1, answer + temp, temp, all);
		}

	}

}
