package silver3.B1966;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<int[]> queue = new ArrayList<>(); // index, 중요도
	static int TC;
	static int N, M;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		out: for (int t = 0; t < TC; t++) {
//			System.out.println("#" + t);
			int answer = 0;
			queue.clear();
			StringTokenizer str = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(str.nextToken()); // 문서의 갯수
			M = Integer.parseInt(str.nextToken()); // 목표 위치
			str = new StringTokenizer(br.readLine(), " ");
			for (int n = 0; n < N; n++) {
				queue.add(new int[] { n, Integer.parseInt(str.nextToken()) });
			}
			do {
//				System.out.println();
//				for (int[] qu : queue) {
//					System.out.print(Arrays.toString(qu) + " ");
//				}
				int[] out = queue.get(0);
				int idx = 1;
				while (idx < queue.size() && queue.get(idx)[1] <= out[1]) {
					idx++;
				}
				if (idx == queue.size()) {
					if (out[0] == M) {
						sb.append(answer + 1).append("\n");
						continue out;
					} else {
						queue.remove(0);
						answer++;
					}
				} else {
					queue.add(queue.remove(0));
				}
			} while (queue.size()>0);
		}
		System.out.println(sb.toString());

	}

}
