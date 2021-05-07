package silver2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B1713_Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		ArrayList<Integer> al = new ArrayList<>(); // [0] : 학생번호, [1] : 추천받은 횟수
		int[] arr = new int[101];

		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		while (str.hasMoreTokens()) {
			int a = Integer.parseInt(str.nextToken());
			if (al.contains(a)) {
				arr[a]++;
				continue;
			} else {
				if (al.size() >= N) {
					int j = 0;
					for (int i = 0; i < al.size(); i++) {
						if (arr[al.get(i)] < arr[al.get(j)]) {
							j = i;
						}
					}
					arr[al.get(j)] = 0;
					al.remove(j);
				}
				arr[a] = 1;
				al.add(a);
			}
		}
		Collections.sort(al);
		StringBuilder sb = new StringBuilder();
		for (int i : al) {
			sb.append(i + " ");
		}
		System.out.println(sb.toString());

	}

}
