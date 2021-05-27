package d3.S3809;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	static StringBuilder input;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer str = null;

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			input = new StringBuilder();
			while (N > 0) {
				str = new StringTokenizer(br.readLine(), " ");
				while (str.hasMoreTokens()) {
					input.append(str.nextToken());
					N--;
				}
			}
			boolean check = false;
			int i = 0;
			for (; i < Integer.MAX_VALUE; i++) {
				if (input.toString().contains(i + "")) {
					continue;
				}
				check = true;
				break;
			}

			if (check) {
				sb.append("#").append(t).append(" ").append(i).append("\n");
			}

		}

		bw.write(sb.toString());
		bw.flush();

	}

}
