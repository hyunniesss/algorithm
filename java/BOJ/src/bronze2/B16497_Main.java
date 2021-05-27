package bronze2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16497_Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] books = new int[32]; // 대여날짜
		int max = -1;
		for (int i = 0; i < N; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(str.nextToken());
			int end = Integer.parseInt(str.nextToken());
			for (int s = start; s < end; s++) {
				books[s]++;
				max = Math.max(books[s], max);
			}
		}
		int K = Integer.parseInt(br.readLine());
		System.out.println(max > K ? 0 : 1);
	}

}
