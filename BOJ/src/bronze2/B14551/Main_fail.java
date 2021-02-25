package bronze2.B14551;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_fail {

	static int N, M;
	static int[] A;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		int answer = 1 % M;
		for (int n = 0; n < N; n++) {
			int input = Integer.parseInt(br.readLine()) % M;
			answer *= (input == 0 ? 1 : input);
			answer %= M;
		}

		System.out.println(answer);
	}

}
