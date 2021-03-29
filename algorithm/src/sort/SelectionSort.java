package sort;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {

		int[] arr = { 7, 6, 2, 4, 3, 9, 1 };

//		for (int i = 0; i < arr.length; i++) { // 기준
//			int stand = i;
//			for (int j = i + 1; j < arr.length; j++) { // 기준 뒤쪽을 탐색하면서 기준값보다 작은 최소값 찾기
//				if (arr[stand] > arr[j]) {
//					stand = j;
//				}
//			}
//
//			int temp = arr[stand];
//			arr[stand] = arr[i];
//			arr[i] = temp;
//
//			System.out.println(Arrays.toString(arr));
//		}
		
		selectionSort(arr);
	}

	public static void selectionSort(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			// 1. 기준값
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}

			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}

		System.out.println(Arrays.toString(arr));
	}

}
