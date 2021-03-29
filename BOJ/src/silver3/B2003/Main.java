package silver3.B2003;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author hyunhee N(1 ≤ N ≤ 10,000), M(1 ≤ M ≤ 300,000,000)
 */

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());

		int[] arr = new int[N];
		str = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(str.nextToken());
		}

		int start = 0, end = 0, result = 0, count = 0;
		while (start < N) {

			if (result > M || end == N) {
				result -= arr[start];
				start++;
			} else {
				result += arr[end];
				end++;
			}

			if (result == M) {
				count++;
			}

		}

		System.out.println(count);

	}

}
