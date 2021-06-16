package silver4.B1049;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		int min = Integer.MAX_VALUE;

		int[] packages = new int[M];
		int[] individuals = new int[M];
		for (int i = 0; i < M; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			packages[i] = Integer.parseInt(str.nextToken());
			individuals[i] = Integer.parseInt(str.nextToken());
		}

		Arrays.sort(packages);
		Arrays.sort(individuals);

		// 1. 패키지 가장 싼 데에서 사고 나머지 패키지+1
		int temp = packages[0] * ((N / 6) + (N % 6 == 0 ? 0 : 1));
		min = Math.min(temp, min);
//		또는 나머지는 개별구매
		temp = (packages[0] * (N / 6)) + (individuals[0] * (N % 6));
		min = Math.min(temp, min);
		// 2. 전부 개별구매
		temp = individuals[0] * N;
		min = Math.min(temp, min);

		System.out.println(min);
	}

}
