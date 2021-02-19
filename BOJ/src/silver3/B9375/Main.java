package silver3.B9375;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int T, result;
	static StringBuilder sb;

	static Map<String, Integer> type;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			start();

			int N = Integer.parseInt(br.readLine()); // 의상의 수

			for (int i = 0; i < N; i++) {
				StringTokenizer str = new StringTokenizer(br.readLine(), " ");
				str.nextToken();
				addList(str.nextToken());
			} // end input

			for (int a : type.values()) {
				result *= a;
			}

			sb.append(result - 1 + "\n");

		}

		System.out.println(sb);

	}

	private static void addList(String cat) {
		if (type.containsKey(cat)) {
			type.put(cat, type.get(cat) + 1);
		} else {
			type.put(cat, 2);
		}

	}

	private static void start() {
		type = new HashMap<String, Integer>();
		result = 1;
	}

}
