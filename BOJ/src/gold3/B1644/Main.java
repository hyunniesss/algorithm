package gold3.B1644;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] isPrime = new boolean[N + 1];
		for (int i = 2; i <= N / 2; i++) {
			if (!isPrime[i]) {
				for (int j = i + i; j <= N; j += i) {
					isPrime[j] = true;
				}
			}
		} // 에라토스테네스의 체

		for (int i = 2; i <= N; i++) {
			if (!isPrime[i]) {
				int sum = 0;
				for (int j = i; j <= N; j++) {
					if (!isPrime[j]) {
						sum += j;
						if (sum > N) {
							break;
						} else if (sum == N) {
							answer++;
							break;
						}
					}
				}
			}
		}
		
		System.out.println(answer);
	}

}
