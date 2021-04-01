package silver3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1463_Main {

	static int[] memoi;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		memoi = new int[N + 1];
		Arrays.fill(memoi, Integer.MAX_VALUE);
		memoi[0] = 0;
		memoi[1] = 0;
		dfs(N);
		System.out.println(memoi[N]);
	}

	private static int dfs(int n) {

		if (memoi[n] != Integer.MAX_VALUE || n < 2) {
			return memoi[n];
		}

		if (n % 2 == 0) {
			memoi[n] = Math.min(1 + dfs(n / 2), memoi[n]);
		}
		if (n % 3 == 0) {
			memoi[n] = Math.min(1 + dfs(n / 3), memoi[n]);
		}
		memoi[n] = Math.min(1 + dfs(n - 1), memoi[n]);
		return memoi[n];
	}

}
