package silver2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B2841_Main_PriorityQueue {

	static PriorityQueue<Integer>[] prets = new PriorityQueue[6];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(str.nextToken());
		int P = Integer.parseInt(str.nextToken());
		int answer = 0;

		for (int i = 0; i < 6; i++) {
			prets[i] = new PriorityQueue<>(new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1; // 내림차순
				}
			});
		}

		for (int i = 0; i < N; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			int idx = Integer.parseInt(str.nextToken()) - 1;
			int pret = Integer.parseInt(str.nextToken()) - 1;
			if (!prets[idx].contains(pret)) {
				answer++;
				prets[idx].offer(pret);
			}
			while (prets[idx].peek() != pret) {
				prets[idx].poll();
				answer++;
			}
		}

		System.out.println(answer);

	}

}
