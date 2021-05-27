package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1476_Main {

	static final int E = 15, S = 28, M = 19;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer str = new StringTokenizer(br.readLine(), " ");

		int e = Integer.parseInt(str.nextToken());
		int s = Integer.parseInt(str.nextToken());
		int m = Integer.parseInt(str.nextToken());
		int year = 0;
		while (!(e == s && s == m)) {
			e = e - 1 == 0 ? E : e - 1;
			s = s - 1 == 0 ? S : s - 1;
			m = m - 1 == 0 ? M : m - 1;
			year++;
		}

		year += e;

		System.out.println(year);

	}

}
