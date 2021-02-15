package bronze2.B3040;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int[] input = new int[9];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		combi(0, 0, 0, 0);
	}

	private static void combi(int cnt, int sum, int cur, int flag) {
		if (cnt == 7) {
			if (sum == 100) {
				for (int i = 0; i < 9; i++) {
					if ((flag & (1 << i)) == 0) {
						continue;
					}
					System.out.println(input[i]);
				}
				System.exit(0);
			}
		}
		if (sum >= 100) {
			return;
		}
		for (int i = cur; i < 9; i++) {
			if ((flag & (1 << i)) == 0) {
				combi(cnt + 1, sum + input[i], i + 1, flag | (1 << i));
			}
		}
	}

}
