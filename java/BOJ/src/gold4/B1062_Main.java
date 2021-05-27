package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1062_Main {

	static int N, K;
	static int[] words;
	static int max = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(str.nextToken());
		K = Integer.parseInt(str.nextToken());
		words = new int[N];
		for (int n = 0; n < N; n++) {
			char[] input = br.readLine().toCharArray();
			for (int i = 0; i < input.length; i++) {
				words[n] |= 1 << (input[i] - 'a');
			}
		} // 입력

		int flag = 0;
		flag |= 1 << 0;
		flag |= 1 << 2;
		flag |= 1 << 8;
		flag |= 1 << 13;
		flag |= 1 << 19;
		if (K < 5) {
			System.out.println(0);
		} else {
			combi(flag, 5, 1);
			System.out.println(max);
		}

	}

	private static void combi(int flag, int cnt, int cur) {
		if (cnt == K) {
			int temp = 0;
			for (int i = 0; i < N; i++) {
				if ((flag & words[i]) == words[i]) {
					temp++;
				}
			}
			max = Math.max(temp, max);
			return;
		}
		for (int i = cur; i < 26; i++) {
			if ((flag & (1 << i)) != 0) {
				continue;
			}
			combi(flag | (1 << i), cnt + 1, i + 1);
		}
	}

}
