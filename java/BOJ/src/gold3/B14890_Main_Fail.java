package gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14890_Main_Fail {

	static int N, L;
	static int[][] map;
	static boolean[] isCheck; // 경사로가 이미 설치되어 있는 장소면 설치 못함
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우

	public static void main(String[] args) {
		initInput();
		int answer = 0;
		for (int r = 0; r < N; r++) {
			answer += isRoute(r, 1, 3); // 오른쪽으로 쭉
		}
		for (int c = 0; c < N; c++) {
			answer += isRoute(1, c, 2); // 아래쪽으로 쭉
		}
		System.out.println(answer);
	}

	private static int isRoute(int sr, int sc, int d) {
		boolean result = false;
		isCheck = new boolean[N];
		switch (d) {
		case 3:
			result = goRight(sr, sc);
			break;
		case 2:
			result = goDown(sr, sc);
			break;
		}

		return result ? 1 : 0;
	}

	private static boolean goDown(int r, int c) {
		int[] result = canGoDown(r, c);
		r = result[1]; // 다른 놈
		if (r == N) {
			return true;
		}
		if (map[r - 1][c] + 1 == map[r][c] && result[0] >= L) { // 위쪽 애가 작고 경사로를 놓을 수 있는 경우
			makeRoute(r, c, 0);
		} else if (map[r][c] + 1 == map[r - 1][c] && result[0] >= L) { // 아래쪽 애가 작고 경사로를 놓을 수 있는 경우
			makeRoute(r, c, 1);
		} else { // 경사로를 놓을 수 없는 경우
			return false;
		}
		return goDown(r, c);
	}

	private static int[] canGoDown(int r, int c) {
		int cnt = isCheck[r - 1] ? 0 : 1;

		while (r < N && map[r - 1][c] == map[r][c]) {
			if (isCheck[r]) {
				cnt = 0;
			}
			cnt++;
			r++;
		}
		return new int[] { cnt, r };
	}

	private static boolean goRight(int r, int c) {
		int[] result = canGoRight(r, c);
		c = result[1];
		if (c == N) {
			return true;
		}
		if (map[r][c - 1] + 1 == map[r][c] && result[0] >= L) { // 왼쪽 애가 작고 경사로를 놓을 수 있는 경우
			makeRoute(r, c, 2);
		} else if (map[r][c] + 1 == map[r][c - 1] && result[0] >= L) { // 오른쪽 애가 작고 경사로를 놓을 수 있는 경우
			makeRoute(r, c, 3);
		} else { // 경사로를 놓을 수 없는 경우
			return false;
		}
		return goRight(r, c);
	}

	private static void makeRoute(int r, int c, int d) {
		boolean isC = (r == r + dirs[d][0]);
		for (int i = 0; i < L; i++) {
			r += dirs[d][0];
			c += dirs[d][1];
			if (isC) {
				isCheck[c] = true;
			} else {
				isCheck[r] = true;
			}
		}
	}

	private static int[] canGoRight(int r, int c) {
		int cnt = isCheck[c - 1] ? 0 : 1;
		while (c < N && map[r][c - 1] == map[r][c]) {
			if (isCheck[c]) {
				cnt = 0;
			}
			cnt++;
			c++;
		}
		return new int[] { cnt, c };
	}

	private static void initInput() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		try {
			str = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(str.nextToken());
			L = Integer.parseInt(str.nextToken());
			map = new int[N][N];
			for (int r = 0; r < N; r++) {
				str = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(str.nextToken());
				}
			}
		} catch (IOException e) {
		}

	}

}
