package d5.S1812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	static StringBuilder sb = new StringBuilder();
	static PriorityQueue<int[]> pq;
	static PriorityQueue<Integer> input;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				Arrays.sort(o1);
				Arrays.sort(o2);
				return o2[1] - o1[1];
			}
		});
		input = new PriorityQueue<>();

		for (int t = 1; t <= T; t++) {
			pq.clear();
			input.clear();
			StringTokenizer str = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(str.nextToken());
			int M = Integer.parseInt(str.nextToken());
			pq.offer(new int[] { M, M });
			str = new StringTokenizer(br.readLine(), " ");
			for (int n = 0; n < N; n++) {
				input.offer(1 << Integer.parseInt(str.nextToken()));
			}
			while (!input.isEmpty()) {
				int cur = input.poll();
				int[] market = pq.poll();
				if (market[1] - cur < 0 || market[0] - cur < 0) {
					pq.offer(new int[] { M - cur, M - cur });
				} else {
					pq.offer(new int[] { market[0] - cur, market[1] - cur });
				}
			}
			sb.append("#").append(t).append(" ").append(pq.size()).append("\n");
			System.out.println("#" + t + " " + pq.size());
			
		}

		System.out.println(sb);

	}

}
