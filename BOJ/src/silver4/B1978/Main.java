package silver4.B1978;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static boolean[] prime = new boolean[1001];

	public static void main(String[] args) throws Exception {

		prime[0] = true;
		prime[1] = true;
		for (int i = 2; i < 500; i++) {
			if (!prime[i]) {
				for (int j = i + i; j <= 1000; j += i) {
					prime[j] = true;
				}
			}
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		int answer = 0;
		for (int n = 0; n < N; n++) {
			if (!prime[Integer.parseInt(str.nextToken())]) {
				answer++;
			}
		}
		
		System.out.println(answer);

	}

}
