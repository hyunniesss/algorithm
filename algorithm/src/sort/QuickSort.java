package sort;

import java.util.Arrays;

public class QuickSort {

	static int[] arr;

	public static void main(String[] args) {

		arr = new int[] { 2, 13, 6, 5, 12, 15, 23, 17, 19, 10 };

		quickSort(0, arr.length - 1);
		System.out.println(Arrays.toString(arr));

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
