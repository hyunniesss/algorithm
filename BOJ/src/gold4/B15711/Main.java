package gold4.B15711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author hyunhee T(1 ≤ T ≤ 500) 1 ≤ A, B ≤ 2 × 10^12
 * 
 *         String에 소수가 아닌 수를 넣자. , 붙여서ㅇㅋ contains 안되있으면 그게 소수임 -> 더해서 4 * 10^12
 *         까지 해봐야해
 */

public class Main {

	static String isPrime = "";
	static final long MAX = 4 * (long) Math.pow(10, 12);

	public static void main(String[] args) throws Exception {

		for (long i = 2; i <= MAX / 2; i++) {
			if (!isPrime.contains(i + ", ")) {
				for (long j = i + i; j <= MAX; j += i) {
					isPrime += j + ", ";
				}
			}
		}
		System.out.println(isPrime);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		long[] sum = new long[T];
		long max = -1;
		for (int t = 0; t < T; t++) {
			StringTokenizer str = new StringTokenizer(br.readLine(), " ");
			sum[t] = Long.parseLong(str.nextToken()) + Long.parseLong(str.nextToken());
			max = sum[t] > max ? sum[t] : max;
//			boolean flag = false;
//			for(long i=2;i<=sum/2;i++) {
//				if(isPrime.contains(i+", ") || isPrime.contains(sum-i+", ")) {
//					continue;
//				} else {
//					System.out.println("YES");
//					flag = true;
//					break;
//				}
//			}
//			if(!flag) {
//				System.out.println("NO");
//			}
		}
		

	}

}
