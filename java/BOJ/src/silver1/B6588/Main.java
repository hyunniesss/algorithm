package silver1.B6588;

/**
 * @author hyunhee
 * (6 ≤ n ≤ 1000000)
 * 입력의 마지막 줄에는 0
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static boolean[] isPrime = new boolean[1000001];
	static int sum = 0, N;
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {

		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		makePrime();

		while (N != 0) {
			boolean flag = false;
			for (int i = 3; i < N; i++) {
				if (!isPrime[i] && !isPrime[N - i]) {
					sb.append(N).append(" = ").append(i).append(" + ").append(N - i);
					flag = true;
					break;
				}
			}
			if (!flag) {
				sb.append("Goldbach's conjecture is wrong.");
			}
			sb.append("\n");
			N = Integer.parseInt(br.readLine());
		}

		System.out.println(sb.toString());

	}

	private static void makePrime() {

		for (int i = 2; i <= isPrime.length / 2; i++) {
			if (!isPrime[i]) {
				for (int j = i + i; j < isPrime.length; j += i) {
					isPrime[j] = true;
				}
			}
		}

	}

}
