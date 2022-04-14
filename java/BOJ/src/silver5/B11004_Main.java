package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11004_Main {

	static int[] arr;
	static int K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;

		str = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(str.nextToken());
		K = Integer.parseInt(str.nextToken());
		arr = new int[K];
		int k = 0;

		str = new StringTokenizer(br.readLine(), " ");
		while (N-- > 0) {
			int next = Integer.parseInt(str.nextToken());
			if (k < K) {
				arr[k++] = next;
			} else {
				Arrays.sort(arr);
				arr[K - 1] = arr[K - 1] > next ? next : arr[K - 1];
			}
		}
		Arrays.sort(arr);
		System.out.println(arr[K-1]);

	}

}
