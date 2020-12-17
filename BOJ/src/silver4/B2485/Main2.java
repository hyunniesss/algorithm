package silver4.B2485;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] trees = new int[N];
		for (int n = 0; n < N; n++) {
			trees[n] = Integer.parseInt(br.readLine());
		}
		int[] dif = new int[N - 1];
		for (int n = 0; n < N - 1; n++) {
			dif[n] = trees[n + 1] - trees[n];
		}
		Arrays.sort(dif);
		int gcd = dif[0];
		for(int n=1;n<N-1;n++) {
			gcd = gcd(gcd, dif[n]);
		}
		int sum = 0;
		for (int n = 0; n < N - 1; n++) {
			sum += dif[n] / gcd - 1;
		}
		System.out.println(sum);

	}

	private static int gcd(int a, int b) {
		while (b > 0) {
			int tmp = a;
			a = b;
			b = tmp % b;
		}
		return a;
	}

}
