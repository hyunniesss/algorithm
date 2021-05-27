package level1.실패율;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @author hyunhee 실패율 : 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
 */

public class Solution {

	public static void main(String[] args) {
		int N = 5;
		int[] stages = { 2, 1, 2, 6, 2, 4, 3, 3 };
//		solution(N, stages);
		stages = new int[] { 4, 4, 4, 4, 4 };
		N = 4;
//		System.out.println(Arrays.toString(solution(N, stages)));
		stages = new int[] { 2, 2, 2, 2 };
		N = 4;
//		System.out.println(Arrays.toString(solution(N, stages)));
		stages = new int[] {1,4};
		N = 4;
		System.out.println(Arrays.toString(solution(N, stages)));

	}

	public static int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		long[] mother = new long[N + 2];
		long[] son = new long[N + 2];
		for (int i = 0; i < stages.length; i++) {
			int stage = stages[i];
			for (int j = 1; j <= stage; j++) {
				mother[j]++;
			}
			son[stage]++;
		} // stage 계산 끝
		double[][] failure = new double[N][2];
		for (int i = 0; i < N; i++) {
			failure[i][0] = i + 1;
			if (mother[i + 1] == 0) {
				failure[i][1] = 0.0f;
			} else {
				failure[i][1] = son[i + 1] / (double) mother[i + 1];
			}
		}
		Arrays.sort(failure, new Comparator<double[]>() {

			@Override
			public int compare(double[] o1, double[] o2) {
				return o1[1] <= o2[1] ? (o1[1]==o2[1] ? 0 : 1) : -1;
			}

		});
		for (int i = 0; i < N; i++) {
			answer[i] = (int) failure[i][0];
		}
		return answer;
	}

}
