package gold5.B15683;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author hyunhee <입력> 첫째 줄에 사무실의 세로 크기 N과 가로 크기 M이 주어진다. (1 ≤ N, M ≤ 8) 둘째 줄부터
 *         N개의 줄에는 사무실 각 칸의 정보가 주어진다. 0은 빈 칸, 6은 벽, 1~5는 CCTV를 나타내고, 문제에서 설명한
 *         CCTV의 종류이다. CCTV의 최대 개수는 8개를 넘지 않는다.
 * 
 *         <출력> 첫째 줄에 사각 지대의 최소 크기를 출력한다.
 * 
 */

// dfs 로 풀자.

public class Main {

	static int[][] map;
	static int N, M;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상, 하, 좌, 우
	static List<int[]> cctv = new ArrayList<>();
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		map = new int[N][M];
		int blind = 0;
		for (int r = 0; r < N; r++) {
			str = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < M; c++) {
				int temp = Integer.parseInt(str.nextToken());
				map[r][c] = temp;
				if (temp > 0 && temp < 6) {
					cctv.add(new int[] { r, c });
				} else if (temp == 0) {
					blind++;
				}
			}
		} // end input

		dfs(0, blind);
		
		System.out.println(min);
	}

	private static void dfs(int index, int blind) {
		if (index == cctv.size()) {
			min = Math.min(blind, min);
			return;
		}
		int[] tv = cctv.get(index);
		switch(map[tv[0]][tv[1]]) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		}
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}
