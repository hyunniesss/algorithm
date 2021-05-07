package silver1.B14888;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] arr;
	static int[] numbers;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		arr = new int[N - 1];
		str = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(str.nextToken());
		}

		str = new StringTokenizer(br.readLine(), " "); // 덧,뺄,곱,나
		int idx = 0, i = 0;
		while (str.hasMoreTokens()) {
			int cnt = Integer.parseInt(str.nextToken());
			while (cnt-- > 0) {
				arr[i++] = idx;
			}
			idx++;
		}

		do {

			calc();

		} while (NP());

		System.out.println(MAX + "\n" + MIN);

	}

	static int MAX = Integer.MIN_VALUE, MIN = Integer.MAX_VALUE;

	private static void calc() {

		int temp = numbers[0];
		for (int i = 0; i < arr.length; i++) {
			switch (arr[i]) {
			case 0: // 덧
				temp += numbers[i + 1];
				break;
			case 1: // 뺄
				temp -= numbers[i + 1];
				break;
			case 2: // 곱
				temp *= numbers[i + 1];
				break;
			case 3: // 나
				if (temp < 0) {
					temp = -((-temp) / numbers[i + 1]);
				} else {
					temp /= numbers[i + 1];
				}
			}
		}

		MAX = Math.max(temp, MAX);
		MIN = Math.min(temp, MIN);
	}

	private static boolean NP() {

//		1. 꼭짓점 찾기(=i)
		int i = N - 2;
		while (i > 0 && arr[i - 1] >= arr[i]) {
			i--;
		}
		if (i == 0) {
			return false;
		}

//		2. i-1과 교환할 큰 값 찾기(=j)
		int j = N - 2;
		while (arr[i - 1] >= arr[j]) {
			j--;
		}

//		3. swap(i-1, j)
		swap(i - 1, j);

//		4. i ~ N-2까지 오름차순 정렬
		int k = N - 2;
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
