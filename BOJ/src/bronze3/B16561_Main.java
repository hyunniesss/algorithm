package bronze3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B16561_Main {

	static int N;
	static int answer;
	static int[] number = new int[3];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		combi(1, 0, 0);
		System.out.println(answer);
	}

	private static void combi(int cur, int sum, int cnt) { // 중복 조합
		if (cnt == 3) {
			if (sum == N) {
				Arrays.sort(number);
				do {
					answer++;
				} while (nextPermutation());
			}
			return;
		}

		for (int i = cur; i < N/3 - 1; i++) {
			if (sum + i * 3 > N) {
				return;
			}
			number[cnt] = i * 3;
			combi(i, sum + number[cnt], cnt + 1);
		}
	}

	private static boolean nextPermutation() { // 중복 순열
		int i = number.length - 1;
		while (i > 0 && number[i - 1] >= number[i]) {
			i--;
		}
		if (i == 0) {
			return false;
		}

		int j = number.length - 1;
		while (number[i - 1] >= number[j]) {
			j--;
		}

		int temp = number[i - 1];
		number[i - 1] = number[j];
		number[j] = temp;

		int k = number.length - 1;
		while (i < k) {
			temp = number[i];
			number[i] = number[k];
			number[k] = temp;
			i++;
			k--;
		}
		return true;
	}

}
