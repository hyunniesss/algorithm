package sort;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {

		int[] data = { 9, 6, 2, 4, 3, 7, 1 };

		bs(data);

		System.out.println(Arrays.toString(data));

	}

	private static void bs(int[] data) {

		for (int i = 0; i < data.length; i++) { // 횟수
			for (int j = 0; j < data.length - i - 1; j++) { // 교환 위치
				if (data[j] > data[j + 1]) {
					int temp = data[j];
					data[j] = data[j + 1];
					data[j + 1] = temp;
				}
			}
			System.out.println((i + 1) + "번 째 : " + Arrays.toString(data));
		}

	}

}
