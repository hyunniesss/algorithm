package silver2.B1929;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		int MIN = Integer.parseInt(str.nextToken());
		int MAX = Integer.parseInt(str.nextToken());
		boolean[] isPrime = new boolean[MAX + 1];
		isPrime[0] = true;
		isPrime[1] = true;
		for (int i = 2; i <= MAX / 2; i++) {
			if (!isPrime[i]) {
				for (int j = i + i; j <= MAX; j += i) {
					isPrime[j] = true;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(;MIN<=MAX;MIN++) {
			sb.append(isPrime[MIN] ? "" : MIN+"\n");
		}
		System.out.println(sb);

	}

}
