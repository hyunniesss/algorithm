package sort;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = { 9, 6, 2, 4, 3, 7, 1 };
//		for (int i = 1; i < arr.length; i++) { // 얘가 새로 삽입할 위치 찾는 애
//			int temp = arr[i];
//			int j = i - 1;
//			while (j >= 0 && temp < arr[j]) {
//				arr[j + 1] = arr[j];
//				j--;
//			}
//			arr[j + 1] = temp;
//
//			System.out.println(Arrays.toString(arr));
//		}
		System.out.println(Arrays.toString(arr));
		insertionSort(arr);

	}

	public static void insertionSort(int[] arr) {

		for (int i = 1; i < arr.length; i++) {
			int standard = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > standard) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = standard;
		}

		System.out.println(Arrays.toString(arr));
	}

}
