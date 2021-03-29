package search;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {

		int[] arr = { 2, 13, 6, 5, 12, 15, 23, 17, 19, 10 };

		System.out.println(bs(arr, 17));
	}

	private static int bs(int[] arr, int target) {

		Arrays.sort(arr);
		
		System.out.println(Arrays.toString(arr));
		
		int left = 0, right = arr.length - 1, mid;

		while (left < right) {

			mid = (left + right) / 2;
			if (arr[mid] == target) {
				System.out.println("FIND TARGET : " + target + ", VALUE : " + arr[mid]);
				return mid;
			}
			if (target < arr[mid]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}

		}

		return -1;
	}

}
