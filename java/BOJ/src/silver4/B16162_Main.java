package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16162_Main {

	static int N, A, D;

	public static void main(String[] args) {
		int[] arr = initInput();
		int max = getMaxNote(arr);
		System.out.println(max);
	}

	private static int getMaxNote(int[] arr) {

		int cnt = 0;
		int next = A;
		for (int i = 0; i < N; i++) {
			if (arr[i] == next) {
				cnt++;
				next += D;
			}
		}
		return cnt;
	}

	private static int[] initInput() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		int[] arr = null;
		try {
			str = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(str.nextToken());
			A = Integer.parseInt(str.nextToken());
			D = Integer.parseInt(str.nextToken());
			arr = new int[N];
			str = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(str.nextToken());
			}
		} catch (IOException e) {
		}
		return arr;
	}

}
