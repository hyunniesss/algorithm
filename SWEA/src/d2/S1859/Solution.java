package d2.S1859;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int T, N, max, maxIdx; // 2 ≤ N ≤ 1,000,000 (10^6)
	static int[] input;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine());
			input = new int[N];

			StringTokenizer str = new StringTokenizer(br.readLine(), " ");
			max = -1;
			maxIdx = -1;
			for (int n = 0; n < N; n++) {
				input[n] = Integer.parseInt(str.nextToken());
			}
			long answer = 0;
			while (maxIdx != N - 1) {
				max = -1;
				int start = maxIdx + 1;
				for (int n = start; n < N; n++) {
					if (max < input[n]) {
						maxIdx = n;
						max = input[n];
					}
				} // max값 찾아서
				for (int n = start; n < maxIdx; n++) {
					answer -= input[n];
				}
				answer += (input[maxIdx] * (maxIdx - start));
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);

	}

}
