package silver4.B11866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(str.nextToken());
		int K = Integer.parseInt(str.nextToken());
		List<Integer> list = new ArrayList<Integer>();
		StringBuilder sb = new StringBuilder();
		sb.append("<");

		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		int idx = K - 1;
		do {
			while (idx >= list.size()) {
				idx -= list.size();
			}
			sb.append(list.remove(idx)).append(", ");
			idx += K - 1;
		} while (list.size() > 0);

		String answer = sb.toString();
		answer = answer.substring(0, answer.length() - 2) + ">";

		System.out.println(answer);

	}

}
