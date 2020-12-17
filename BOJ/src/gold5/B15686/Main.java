package gold5.B15686;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author hyunhee 
 * 치킨 거리: 집과 가장 가까운 치킨집 사이의 거리 
 * (r1, c1)과 (r2, c2) 사이의 거리 : |r1-r2| + |c1-c2| 
 * 도시의 치킨 거리: 모든 집의 치킨 거리의 합 
 * <입력> N(2 ≤ N ≤ 50)과 M(1 ≤ M ≤ 13) 
 * N개의 줄: 도시의 정보 (0은 빈 칸, 1은 집, 2는 치킨집) 
 * <출력> 치킨집을 최대 M개를 골랐을 때, 도시의 치킨 거리의 최솟값
 */

public class Main {

	static int N, M, MIN = Integer.MAX_VALUE;
	static List<int[]> chicken = new ArrayList<>();
	static int[] choice;
	static List<int[]> home = new ArrayList<>();

	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		choice = new int[M];
		for (int r = 0; r < N; r++) {
			str = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < N; c++) {
				int chick = Integer.parseInt(str.nextToken());
				if (chick == 2) {
					chicken.add(new int[] { r, c });
				} else if (chick == 1) {
					home.add(new int[] { r, c });
				}
			}
		}
		combi(0, 0);
		System.out.println(MIN);
	}

	private static void combi(int cur, int cnt) {
		if (cnt == M) {
			int sum = 0;
			for (int i = 0; i < home.size(); i++) {
				int min = Integer.MAX_VALUE;
				int[] ho = home.get(i);
				for (int j = 0; j < M; j++) {
					int[] ch = chicken.get(choice[j]);
					int distance = Math.abs(ch[0] - ho[0]) + Math.abs(ch[1] - ho[1]);
					min = Math.min(distance, min);
				}
				sum += min;
			}
			MIN = sum < MIN ? sum : MIN;
			return;
		}
		for (int i = cur; i < chicken.size(); i++) {
			choice[cnt] = i;
			combi(i + 1, cnt + 1);
		}
	}

}
