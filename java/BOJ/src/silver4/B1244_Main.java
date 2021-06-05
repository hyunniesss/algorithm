package silver4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1244_Main {

	static int[] arr;
	static int N, K;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;

		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		arr[0] = -1;

		str = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(str.nextToken());
		}

		K = Integer.parseInt(br.readLine());
		while (K-- > 0) {
			str = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			switch (a) {
			case 1:
				isMale(b);
				break;
			case 2:
				isFemale(b);
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(arr[i]).append(" ");
			if (i % 20 == 0) {
				sb.append("\n");
			}
		}

		System.out.println(sb.toString());
	}

	private static void isFemale(int b) {
		int i = 1;
		while (true) {
			if (isOut(b, i) || arr[b + i] != arr[b - i]) {
				break;
			}
			i++;
		}
		i--;
		for (int j = b - i; j <= b + i; j++) {
			arr[j] = (arr[j] + 1) % 2;
		}

	}

	private static boolean isOut(int b, int i) {
		return (b + i) > N || (b - i) <= 0;
	}

	private static void isMale(int b) {

		for (int i = b; i <= N; i += b) {
			arr[i] = (arr[i] + 1) % 2;
		}

	}

}
