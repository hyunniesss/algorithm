package gold5.B9663;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int N, answer = 0;
	static boolean[][] map;
	static int[][] dirs = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new boolean[N][N];
		dfs(0);

		System.out.println(answer);
	}

	private static void dfs(int cnt) {
		
	}

}
