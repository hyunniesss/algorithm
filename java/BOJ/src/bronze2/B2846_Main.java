package bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2846_Main {

	public static void main(String[] args) {
		int[] arr = initInput();
		int max = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			int si = i;
			while (i < arr.length - 1 && arr[i] < arr[i + 1]) {
				i++;
			}
			if (si == i) {
				continue;
			}
			max = Math.max(arr[i] - arr[si], max);
		}
		System.out.println(max);
	}

	private static int[] initInput() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N, arr[] = null;
		try {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			StringTokenizer str = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(str.nextToken());
			}
		} catch (NumberFormatException | IOException e) {
		}

		return arr;
	}

}
