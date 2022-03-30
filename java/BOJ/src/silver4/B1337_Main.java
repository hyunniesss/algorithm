package silver4;

import java.util.Arrays;
import java.util.Scanner;

public class B1337_Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int maxCnt = 4;
		int N = sc.nextInt();
//		ArrayList<Integer> arrList = new ArrayList<>();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();

		Arrays.sort(arr);
		for (int i = 0; i < N; i++) {
			int cnt = 1;
			for (int j = 1; j < 5; j++) {
				if (Arrays.binarySearch(arr, arr[i] + j) >= 0) {
					cnt++;
				}
			}
			maxCnt = Math.min(maxCnt, 5 - cnt);
		}

		System.out.println(maxCnt);

	}

}
