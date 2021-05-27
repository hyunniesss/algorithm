package silver3.B1003;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int[] memoi = new int[41];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		memoi[0] = 0;
		memoi[1] = 1;
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			fibonacci(N); // one
			if (N == 0) {
				sb.append(memoi[1]).append(" ").append(memoi[0]).append("\n");
			} else {
				sb.append(memoi[N-1]).append(" ").append(memoi[N]).append("\n");
			}
		}
		
		System.out.println(sb);

	}

	private static int fibonacci(int n) {
		if (memoi[n] > 0 || n == 0) {
			return memoi[n];
		}
		memoi[n] = fibonacci(n - 1) + fibonacci(n - 2);
		return memoi[n];
	}

}
