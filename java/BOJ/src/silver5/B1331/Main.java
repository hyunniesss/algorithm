package silver5.B1331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static final int N = 6;

	static int[][] dirs = { { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 } };
	static boolean[][] map = new boolean[N + 2][N + 2];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String start = br.readLine();
		int sc = start.charAt(0) - 'A';
		int sr = start.charAt(1) - '0';
		if (!map[sr][sc]) {
			map[sr][sc] = true;
		}

		int pr = sr;
		int pc = sc;

		int tempC, tempR, nC, nR;
		boolean isValid = true;

		for (int i = 1; i < N * N; i++) {
			String next = br.readLine();
			tempC = next.charAt(0) - 'A';
			tempR = next.charAt(1) - '0';

			boolean flag = false;
			for (int z = 0; z < dirs.length; z++) {
				nR = pr + dirs[z][0];
				nC = pc + dirs[z][1];
				if (nR == tempR && nC == tempC) {
					flag = true;
					break;
				}
			}

			if (flag && !map[tempR][tempC]) {
				map[tempR][tempC] = true;
			} else {
				isValid = false;
			}
			pr = tempR;
			pc = tempC;
		}

		if (isValid) {
			for (int z = 0; z < dirs.length; z++) {
				nR = pr + dirs[z][0];
				nC = pc + dirs[z][1];
				if (nR == sr && nC == sc) {
					isValid = true;
					break;
				} else {
					isValid = false;
				}
			}
		}

		System.out.println(isValid ? "Valid" : "Invalid");

	}

}
