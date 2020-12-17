package silver3.B2003;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author hyunhee N(1 ≤ N ≤ 10,000), M(1 ≤ M ≤ 300,000,000) A[x]는 30,000을 넘지 않는
 *         자연수
 */

public class Main {

	static int N;
	static long M;
	static int[] A;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(str.nextToken());
		M = Long.parseLong(str.nextToken());
		A = new int[N];

		str = new StringTokenizer(br.readLine(), " ");
		for (int n = 0; n < N; n++) {
			A[n] = Integer.parseInt(str.nextToken());
		}
		int answer = 0;

		for (int f = 0; f < N; f++) {
			long sum = 0;
			for (int b = f + 1; b <= N; b++) {
				sum += A[b - 1];
				if (sum > M) {
					break;
				} else if (sum == M) {
					answer++;
					break;
				}
			}
		}
		
		System.out.println(answer);

	}

}
