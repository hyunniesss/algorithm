package gold4.B1027;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author hyunhee i < j < k에 대해, i번 건물에서 k번 건물을 볼 때 j번 건물이 이를 방해하지 않으려면 i번 건물의
 *         끝과 k번 건물의 끝을 연결한 선의 기울기가 i번 건물의 끝과 j번 건물의 끝을 연결한 기울기보다 커야합니다.
 */

public class Main {

	static long[] tower;
	static int N, MAX;
	static int[] ccw;

	public static void main(String[] args) throws Exception {

		initGame();

		for (int i = 0; i < N; i++) { // 현재 빌딩
			int count = 0;
			double maxAngle = Double.MIN_VALUE;
			// 왼쪽 빌딩
			for (int j = i - 1; j >= 0; j--) {
				double ccw = (tower[j] - tower[i]) / (j - i);
				maxAngle = Math.max(maxAngle, ccw);
				if (maxAngle > ccw) {
					count++;
				}
			}

			maxAngle = Double.MIN_VALUE;
			// 오른쪽 빌딩
			for (int j = i + 1; j < N; j++) {
				double ccw = (tower[j] - tower[i]) / (j - i);
				maxAngle = Math.max(maxAngle, ccw);
				if (maxAngle > ccw) {
					count++;
				}
			}

			MAX = Math.max(count, MAX);

		}

		System.out.println(MAX / 2 + 1);

	}

	private static void initGame() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		tower = new long[N];

		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		for (int n = 0; n < N; n++) {
			tower[n] = Integer.parseInt(str.nextToken());
		}

	}

}
