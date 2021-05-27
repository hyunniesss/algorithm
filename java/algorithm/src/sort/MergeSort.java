package sort;

import java.util.Arrays;

public class MergeSort {

	static int[] temp;

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 8, 5, 4, 2, 3, 7, 6 };
		temp = new int[arr.length]; // 정렬된 배열을 관리할 배열

		arr = mergeSort(arr, 0, arr.length - 1);

		System.out.println(Arrays.toString(arr));

	}

	private static int[] mergeSort(int[] a, int start, int end) {

		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(a, start, mid); // 왼쪽 배열
			mergeSort(a, mid + 1, end); // 오른쪽 배열
			a = merge(a, start, mid, end);
		}

		return a;
	}

	private static int[] merge(int[] a, int start, int mid, int end) {
		int i = start;
		int j = mid + 1;
		int k = start;

		while (i <= mid && j <= end) {
			if (a[i] < a[j]) {
				temp[k++] = a[i++];
			} else {
				temp[k++] = a[j++];
			}
		}

		// 이 밑은 i> mid 또는 j > end

		if (mid < i) {
			for (int l = j; l <= end; l++) {
				temp[k++] = a[l];
			}
		} else {
			for (int l = i; l <= mid; l++) {
				temp[k++] = a[l];
			}
		}

		for (int l = start; l <= end; l++) {
			a[l] = temp[l];
		}

		System.out.println(Arrays.toString(a));

		return a;
	}

}
