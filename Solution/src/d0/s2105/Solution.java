package d0.s2105;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * @author hyunhee 1. 입력 처리 max를 0으로 초기화 N 입력 받아서 N*N 배열 생성 boolean[N][N]
 *         visited 배열 데이터 읽기 2. 탐색 (DFS) N*N 반복 돌면서 i, j번째 카페부터 투어 시작좌표 = i, j 로
 *         초기화 set 초기화 visited 배열 초기화 DFS 탐색 (i, j, d) - 현재 노드에 대한 방문 처리 & set에
 *         현재 노드 추가 - 현재 방향에서부터 <4 반복하면서 다음좌표가 시작좌표이고 cnt>=4 인지 검사 == 한바퀴 탐색했으니
 *         Math.max(cnt, max) 3. 출력 max == 0 ? -1 : max
 *
 */

public class Solution {

	static int N; // 맵 크기
	static int MAX; // 디저트 먹은 최대 개수
	static int SR, SC; // 시작좌표
	static int[][] map;
	static boolean[][] visited; // 방문 처리
	static HashSet<Integer> list = new HashSet<>(); // 중복값 처리

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
			visited = new boolean[N][N];

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
//					set 초기화
					list.clear();
//					visited 초기화
					for (int k = 0; k < N; k++) {
						Arrays.fill(visited[k], false);
					}
					dfs(i, j, 0);
				}
			}

//			출력
			System.out.println("#" + t + " " + (MAX == 0 ? -1 : MAX));
		}

	}

	private static void dfs(int r, int c, int d) {
//		현재 노드에 대한 방문 체크
		visited[r][c] = true;
		list.add(map[r][c]);

//		현재방향에서부터 < 4 반복
		for (int i = d; i < 4; i++) {
//			다음좌표가 시작좌표이고 cnt>=4인가
			int nr = r + dirs[i][0];
			int nc = c + dirs[i][1];
			int cnt = list.size();
			if (nr == SR && nc == SC && cnt >= 4) {
				if (cnt > MAX) {
					MAX = cnt;
				}
				return;
			}

//			다음좌표가 경계 내에 있고 방문한 적 없고 처음 먹는 디저트인가
			if (nr > -1 && nr < N && nc > -1 && nc < N && !visited[nr][nc] && !list.contains(map[nr][nc])) {
				dfs(nr, nc, d);
			}
		}

//		현재노드에 대한 방문 해체
		visited[r][c] = false;
		list.remove(map[r][c]);

	}

}
