package gold5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1038_Main {

	public static void main(String[] args) {

		// 입력
		int N = -1;
		try {
			N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		} catch (Exception e) {
		}
		/*
		 * long[] arr = new long[500001]; arr[1] = 9; for(int i=2;i<=500000;i++) {
		 * for(int j=1;j<i;j++) { for(int k=1;k<=arr[j];k++) { arr[i] += k; } } }
		 */
		if (N <= 10) {
			System.out.println(N);
			return;
		}
		long[] arr;
		try {
			arr = new long[N + 1];

			for (int i = 0; i < 10; i++) {
				arr[i] = i;
			}
			int i = 10, j = 0;
			while (i <= N) {
				long temp = arr[j] * 10;
				while (i <= N && arr[j] % 10 > temp % 10) {
					arr[i++] = temp++;
				}
				j++;
			}
			System.out.println(arr[N]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(-1);
		}
	}

}
