package silver4.B2960;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author hyunhee 1. 2부터 N까지 모든 정수를 적는다. 2. 아직 지우지 않은 수 중 가장 작은 수를 찾는다. 이것을 P라고
 *         하고, 이 수는 소수이다. 3. P를 지우고, 아직 지우지 않은 P의 배수를 크기 순서대로 지운다. 4. 아직 모든 수를
 *         지우지 않았다면, 다시 2번 단계로 간다.
 */

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(str.nextToken());
		int K = Integer.parseInt(str.nextToken());
		boolean[] isPrime = new boolean[N + 1];
		for (int i = 2; i <= N; i++) {
			if (!isPrime[i]) {
				for (int j = i; j <= N; j += i) {
					if (!isPrime[j]) {
						isPrime[j] = true;
						K--;
					}
					if (K == 0) {
						System.out.println(j);
						return;
					}
				}
			}
		}

	}

}
