package silver5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1010_Main {

	static int T, N, R;
	static StringBuilder sb = new StringBuilder();
	static long[][] memoi;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer str = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(str.nextToken());
			N = Integer.parseInt(str.nextToken());
			memoi = new long[N + 2][N + 2];
			memoi[1][1] = 1;
			memoi[1][2] = 1;
			for (int n = 2; n <= N; n++) {
				for (int r = 1; r <= R + 1; r++) {
					memoi[n][r] = memoi[n - 1][r - 1] + memoi[n - 1][r];
				}
			}
			sb.append(memoi[N][R + 1]).append("\n");
		}

		System.out.println(sb);

	}

}