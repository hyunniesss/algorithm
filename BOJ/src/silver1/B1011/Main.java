package silver1.B1011;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer str = new StringTokenizer(br.readLine(), " ");
			int Y = Integer.parseInt(str.nextToken());
			Y = Integer.parseInt(str.nextToken()) - Y;
			sb.append((-1 + Math.sqrt(1 - 4 * Y)) / 2);
		}

		System.out.println(sb);

	}

}
