package gold5.B1092;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static List<Integer> cranes, boxes;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		cranes = new ArrayList<Integer>();
		boxes = new ArrayList<Integer>();
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			cranes.add(Integer.parseInt(str.nextToken()));
		}

		Collections.sort(cranes);

		M = Integer.parseInt(br.readLine());
		str = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			boxes.add(Integer.parseInt(str.nextToken()));
		}

		Collections.sort(boxes);
		if (boxes.get(M - 1) > cranes.get(N - 1)) {
			System.out.println(-1);
			return;
		}

		int answer = 0;

		while (boxes.size() > 0) {
			int j = boxes.size() - 1;
			for (int i = cranes.size() - 1; i >= 0; i--) {
				int crane = cranes.get(i);
				for (; j >= 0; j--) {
					if (crane >= boxes.get(j)) {
						boxes.remove(j--);
						break;
					}
				}
				if (boxes.isEmpty()) {
					break;
				}
			}
			answer++;

		}

		System.out.println(answer);

	}

}
