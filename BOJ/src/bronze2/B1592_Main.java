package bronze2;

import java.util.Scanner;

public class B1592_Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		int[] arr = new int[N];
		arr[0] = 1;
		int cur = 0;
		int sum = 0;
		while (arr[cur] < M) {
			if (arr[cur] % 2 == 0) {
				cur -= L;
				if (cur < 0) {
					cur += N;
				}
			} else {
				cur += L;
				if (cur >= N) {
					cur -= N;
				}
			}
			arr[cur]++;
			sum++;
		}
		
		System.out.println(sum);

		sc.close();

	}

}
