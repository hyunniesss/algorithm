package silver3.B1004;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author hyunhee 어린왕자 출발점을 감싸고 있는 원의 수 + 도착점을 감싸고 있는 원의 수 - 두 점을 모두 포함하는 원의 수
 *         = 출발점이나 도착점 1개만 포함하고 있는 원의 수
 * 
 *         <입력> 1) 첫째 줄에 출발점 (x1, y1)과 도착점 (x2, y2) 2) 두 번째 줄에는 행성계의 개수 n 3) n줄에
 *         걸쳐 행성계의 중점과 반지름 (cx, cy, r)
 * 
 *         <조건> -1000 ≤ x1, y1, x2, y2, cx, cy ≤ 1000, 1 ≤ r ≤ 1000, 1 ≤ n ≤ 50
 */

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int N;
	static double[][] planet;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringTokenizer str;
		double[][] points = new double[2][2]; // start -> end

		for (int t = 0; t < T; t++) {
			str = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					points[i][j] = Double.parseDouble(str.nextToken());
				}
			}

			N = Integer.parseInt(br.readLine());
			planet = new double[N][3]; // x, y, r
			for (int n = 0; n < N; n++) {
				str = new StringTokenizer(br.readLine(), " ");
				for (int i = 0; i < 3; i++) {
					planet[n][i] = Double.parseDouble(str.nextToken());
				}
			}

			int answer = 0;
			for (int n = 0; n < N; n++) {
				double dist_start = Math
						.sqrt(Math.pow(planet[n][0] - points[0][0], 2) + Math.pow(planet[n][1] - points[0][1], 2));
				double dist_end = Math
						.sqrt(Math.pow(planet[n][0] - points[1][0], 2) + Math.pow(planet[n][1] - points[1][1], 2));
				if (dist_start <= planet[n][2] && dist_end <= planet[n][2]) {
					continue;
				}
				if (dist_start <= planet[n][2] || dist_end <= planet[n][2]) {
					answer++;
				}
			}

			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}

}
