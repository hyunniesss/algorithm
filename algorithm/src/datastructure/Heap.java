package datastructure;

import java.util.Arrays;

public class Heap {

	public static void main(String[] args) {

		int[] arr = { 32, 30, 25, 21, 29, 17, 19, 23, 14 };

//		maxHeap(arr);
		minHeap(arr);

	}

	private static void minHeap(int[] arr) {
		int[] minHeap = new int[arr.length + 1];
		int idx = 0;

		for (int i = 0; i < arr.length; i++) {
			minHeap[++idx] = arr[i];

			for (int j = idx; j > 1; j--) {
				if (minHeap[j / 2] > minHeap[j]) {
					int temp = minHeap[j];
					minHeap[j] = minHeap[j / 2];
					minHeap[j / 2] = temp;
				}
			}

		}

		System.out.println(Arrays.toString(minHeap));
	}

	private static void maxHeap(int[] arr) {

		int[] maxHeap = new int[arr.length + 1];
		int idx = 0;

		for (int i = 0; i < arr.length; i++) {
			maxHeap[++idx] = arr[i];

			for (int j = idx; j > 1; j--) {

				if (maxHeap[j / 2] < maxHeap[j]) {
					int temp = maxHeap[j / 2];
					maxHeap[j / 2] = maxHeap[j];
					maxHeap[j] = temp;
				}
			}

		}

		System.out.println(Arrays.toString(maxHeap));

	}

}
