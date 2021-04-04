package d4.S7701;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

	static int T;
	static String[] arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			int N = Integer.parseInt(br.readLine());
			arr = new String[N];
			for (int i = 0; i < N; i++) {
				arr[i] = br.readLine();
			}

			sb.append("#").append(t).append("\n");

			Arrays.sort(arr, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					if (o1.length() == o2.length()) {
						int idx = 0;
						while (idx < o1.length() && o1.charAt(idx) == o2.charAt(idx)) {
							idx++;
						}
						if (idx == o1.length()) {
							return 0;
						}
						return o1.charAt(idx) - o2.charAt(idx);
					}
					return o1.length() - o2.length();
				}
			});

			String temp = "";

			for (int i = 0; i < N; i++) {
				if (temp.equals(arr[i])) {
					continue;
				}
				temp = arr[i];
				sb.append(arr[i]).append("\n");
			}

		}

		bw.write(sb.toString());
		bw.flush();

	}

}
