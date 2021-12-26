package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11004_Main_QuikSort {
	
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
		quickSort(0, N - 1);
		System.out.println(arr[K-1]);
	}
	
	private static void quickSort(int left, int right) {

		int i, j, pivot, temp;

		if (left < right) {
			i = left;
			j = right;
			pivot = arr[(left + right) / 2]; // 가운데 값
			while (i < j) {
				while (arr[j] > pivot) {
					j--;
				}

				while (i < j && arr[i] < pivot) {
					i++;
				}
				temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}

			quickSort(left, i - 1);
			quickSort(i + 1, right);
		}

	}

}
