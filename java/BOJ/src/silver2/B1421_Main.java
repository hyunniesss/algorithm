package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1421_Main {

	public static void main(String[] args) {

		initInput();

		for (int i = 1; i <= arr[N - 1]; i++) { // 자를 길이
			int cnt = 0, price = 0;
			dfs(i, cnt, price);
		}

		System.out.println(price_M);

	}

	static long price_M;

	private static void dfs(int len, int cnt, long price) {
		if (cnt == N) {
			price_M = Math.max(price, price_M);
			return;
		}

		// 1. 팔 때
		int cutting = arr[cnt] % len == 0 ? arr[cnt] / len - 1 : arr[cnt] / len;// 커팅 몇 번
		int numb = arr[cnt] / len; // 잘랐을 때 팔 수 있는 나무 개수
		long nextP = price + (numb * W * len) - (cutting * C);
		if (nextP > price) {
			dfs(len, cnt + 1, nextP);
		} else {
			dfs(len, cnt + 1, price);
		}
//			// 2. 팔지 않을 때
//			dfs(len, cnt + 1, price);
	}

	static int N; // 나무 개수,
	static long C, W; // 비용, 나무 가격
	static int[] arr;

	private static void initInput() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		try {
			str = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(str.nextToken());
			C = Integer.parseInt(str.nextToken());
			W = Integer.parseInt(str.nextToken());

			arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			Arrays.sort(arr);
		} catch (IOException e) {
		}

	}

}
