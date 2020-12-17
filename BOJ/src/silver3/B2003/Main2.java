package silver3.B2003;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

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
		long sum = A[0];
		int f = 0, b = 1;
		for (; f < N; f++) {
			for (; b <= N; b++) {
				if (sum == M) {
					answer++;
					break;
				} else if (sum > M) {
					break;
				}
				if (b < N)
					sum += A[b];
			}
			sum -= A[f];
		}

		System.out.println(answer);
	}

}
