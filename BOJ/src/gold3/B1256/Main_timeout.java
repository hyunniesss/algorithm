package gold3.B1256;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_timeout {

	static int N, M, K, count;
	static int Len;
	static char[] words;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		K = Integer.parseInt(str.nextToken());
		words = new char[N + M];
		for (int n = 0; n < N; n++) {
			words[n] = 'a';
		}
		for (int m = N; m < N + M; m++) {
			words[m] = 'z';
		}
		Arrays.sort(words);
		Len = words.length;
		do {
			count++;
		} while (count < K && nextPermutation());
		if (count == K) {
			for (char c : words) {
				System.out.print(c);
			}
		} else {
			System.out.println(-1);
		}
	}

	private static boolean nextPermutation() {
		// STEP1. 꼭짓점(i) 찾기
		int i = Len - 1;
		while (words[i - 1] >= words[i]) {
			i--;
		}
		if (i == 0) {
			return false;
		}

		// STEP2. 교환할 j 찾기
		int j = Len - 1;
		while (words[i - 1] >= words[j]) {
			j--;
		}

		// STEP3. [i-1]이랑 [j] 교환
		char temp = words[i - 1];
		words[i - 1] = words[j];
		words[j] = temp;

		// STEP4. i부터 오름차순으로 swap
		int k = Len - 1;
		while (i < k) {
			temp = words[i];
			words[i] = words[k];
			words[k] = temp;
			i++;
			k--;
		}
		return true;
	}
}
