package bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15953_Main {

	static int[] money1 = new int[101];
	static int[] money2 = new int[65];

	static int T;
	static int[][] input;

	public static void main(String[] args) {
		initInput();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			int a = input[i][0];
			int b = input[i][1];
			int money = money1[a] + money2[b];
			if(money == 0) {
				sb.append(money).append("\n");
			} else {
				sb.append(money).append("0000\n");
			}
		}
		System.out.println(sb.toString());
	}

	static int[] arr1 = { 500, 300, 200, 50, 30, 10 };
	static int[] arr2 = { 512, 256, 128, 64, 32 };

	private static void initInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		int idx = 1;
		for (int i = 1; i <= 6; i++) {
			for (int j = 0; j < i; j++) {
				money1[idx++] = arr1[i - 1];
			}
		}
		idx = 1;
		int k = 1;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < k; j++) {
				money2[idx++] = arr2[i];
			}
			k *= 2;
		}
		try {
			T = Integer.parseInt(br.readLine());
			input = new int[T][2];
			for (int i = 0; i < T; i++) {
				str = new StringTokenizer(br.readLine(), " ");
				input[i][0] = Integer.parseInt(str.nextToken());
				input[i][1] = Integer.parseInt(str.nextToken());
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

}
