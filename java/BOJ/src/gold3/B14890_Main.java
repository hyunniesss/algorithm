package gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14890_Main {

	static int N, L;
	static int[][] map;
	static boolean[] isCheck;

	public static void main(String[] args) {
		initInput();
		int answer = 0;
		for (int r = 0; r < N; r++) { // 시작점, 오른쪽으로 감
			isCheck = new boolean[N];
			answer += goRight(r, 0) ? 1 : 0;
		}
		for (int c = 0; c < N; c++) { // 시작점, 아래쪽으로 감
			isCheck = new boolean[N];
			answer += goDown(0, c) ? 1 : 0;
		}
		System.out.println(answer);

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

	private static boolean goDown(int r, int c) {
		int cnt = isCheck[r] ? 0 : 1;
		while (r < N - 1 && map[r][c] == map[r + 1][c]) {
			r++;
			cnt = isCheck[r] ? 0 : cnt + 1;
		}
		if (r == N - 1) { // 전부 동일한 높이
			return true;// 갈 수 있음
		} else { // 길의 끝이 아닐 때 == 높이가 다른 경우
			if (Math.abs(map[r][c] - map[r + 1][c]) == 1) { // 높이 차이가 1
				if (map[r][c] == map[r + 1][c] + 1 && !isCheck[r + 1]) { // 아래가 작으면 아래 설치할 건데
					for (int l = 1; l < L; l++) {
						if (r + 1 + l >= N || map[r + 1 + l][c] != map[r + l][c] || isCheck[r + l + 1]) { // 설치할 수 없으면
							// 범위를 벗어나거나 바닥 높이가 다르거나 경사로를 지을 수 없을 때
							return false;
						}
					}
					for (int l = 1; l <= L; l++) {
						isCheck[r + l] = true;
					}
				}
				return goDown(r + L + 1, c);// 갈 수 있음
			}
//			else {
			return false;// 못감
//			}
		}
	}

	private static boolean goRight(int r, int c) {
		int cnt = 0;
		while (c < N - 1 && map[r][c] == map[r][c + 1]) {
			c++;
			cnt++;
		}
		if (c == N - 1) { // 전부 동일한 높이
			return true;// 갈 수 있음
		} else { // 길의 끝이 아닐 때 == 높이가 다른 경우
			if (Math.abs(map[r][c] - map[r][c + 1]) == 1 && cnt >= L) { // 높이 차이가 1 && 경사로를 놓을 수 있으면
				return goRight(r, c + 1);// 갈 수 있음
			} else {
				return false;// 못감
			}
		}

	}

}
