package silver1.B11051;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static long[][] paskal;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(str.nextToken());
		int K = Integer.parseInt(str.nextToken());
		paskal = new long[N + 2][1001];
		paskal[0][0] = 1;
		paskal[1][0] = 1;
		paskal[1][1] = 1;
		for (int i = 2; i <= N; i++) {
			paskal[i][0] = 1;
			for (int k = 1; k <= i; k++) {
				paskal[i][k] = (paskal[i - 1][k - 1] % 10007 + paskal[i - 1][k] % 10007) % 10007;
			}
		}
		System.out.println(paskal[N][K]);
	}

}
