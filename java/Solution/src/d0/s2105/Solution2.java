package d0.s2105;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution2 {

	static int N; // 맵 크기
	static int MAX; // 디저트 먹은 최대 개수
	static int SR, SC; // 시작좌표
	static int[][] map;
	static boolean[] visited; // 방문 처리

	static int[][] dirs = { { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } }; // 우하, 좌하, 좌상, 우상

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
//			1. max = 0 초기화
			MAX = 0;
//			2. N 입력 받아 배열 생성
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[101]; // 먹은 디저트 중복 체크 & 방문 체크

//			3. 데이터 읽기
			for (int i = 0; i < N; i++) {
				StringTokenizer str = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(str.nextToken());
				}
			}
//			4. dfs 탐색
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
//					시작좌표 초기화
					SR = i;
					SC = j;
//					visited 초기화
					Arrays.fill(visited, false);
					dfs(i, j, 0, 1);
				}
			}

//			출력
			System.out.println("#" + t + " " + (MAX == 0 ? -1 : MAX));
		}

	}

	private static void dfs(int r, int c, int d, int cnt) {
//		현재 노드에 대한 방문 체크
		visited[map[r][c]] = true;

//		현재방향에서부터 < 4 반복
		for (int i = d; i < 4; i++) {
//			다음좌표가 시작좌표이고 cnt>=4인가
			int nr = r + dirs[i][0];
			int nc = c + dirs[i][1];
			if (nr == SR && nc == SC && cnt >= 4) {
				if (cnt > MAX) {
					MAX = cnt;
					return;
				}
			}

//			다음좌표가 경계 내에 있고 방문한 적 없고 처음 먹는 디저트인가
			if (nr > -1 && nr < N && nc > -1 && nc < N && !visited[map[nr][nc]]) {
				dfs(nr, nc, d, cnt + 1);
			}
		}

//		현재노드에 대한 방문 해체
		visited[map[r][c]] = false;
	}

}
