package gold4.B1082;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] price, buy;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		price = new int[N];
		buy = new int[N];

		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			price[i] = Integer.parseInt(str.nextToken());
		}

		for (int i = N - 1; i >= 0; i--) {
			if (price[i] >= min) {
				price[i] = -1;
			} else {
				min = price[i];
			}
		}

		int money = Integer.parseInt(br.readLine());
		String answer = null;
		for (int count = money / min; count > 0; count--) {
			answer = combination(count, money, N - 1);
			if (answer != null) {
				break;
			}
		}
		System.out.println(answer == null ? 0 : answer);

	}

	private static String combination(int count, int money, int cur) {
		String answer = null;
		if (count == 0) {
			// 여기서 계산해야해
			answer = "";
			for (int i = N - 1; i >= 0; i--) {
				for (int j = 0; j < buy[i]; j++) {
					answer += i;
				}
			}
			return answer.charAt(0) == '0' ? null : answer;
		}
		for (int i = cur; i >= 0; i--) {
			if (price[i] >= 0 && money - price[i] >= 0) { // 살 수 있으니까
				buy[i]++;
				answer = combination(count - 1, money - price[i], i);
				if (answer != null) {
					return answer;
				}
				buy[i]--;
			}
		}
		return answer;
	}

}
