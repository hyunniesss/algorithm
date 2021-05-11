package silver2.B10819;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		str = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(str.nextToken());
		}

		Arrays.sort(arr);
		int MAX = -1;
		do {
			int temp = calc();
			MAX = Math.max(temp, MAX);

		} while (NP());

		System.out.println(MAX);

	}

	private static int calc() {
		int temp = 0;
		for (int i = 1; i < N; i++) {
			temp += Math.abs(arr[i - 1] - arr[i]);
		}
		return temp;
	}

	private static boolean NP() {

		int i = N - 1;
		while (i > 0 && arr[i - 1] >= arr[i]) {
			i--;
		}
		if (i == 0) {
			return false;
		}

		int j = N - 1;
		while (arr[i - 1] >= arr[j]) {
			j--;
		}

		swap(i - 1, j);

		int k = N - 1;
		while (i < k) {
			swap(i, k);
			i++;
			k--;
		}

		return true;
	}

	private static void swap(int i, int j) {

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}
}
