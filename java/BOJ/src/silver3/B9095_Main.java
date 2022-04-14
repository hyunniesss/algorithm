package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9095_Main {

	static int T, arr[], dp[];

	public static void main(String[] args) {
		initInput();
		StringBuilder sb = new StringBuilder();
		for (int a : arr) {
			sb.append(makeNumber(a)).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int makeNumber(int a) {
		if(a<0) {
			return 0;
		}
		if (dp[a] > 0) {
			return dp[a];
		}
		return dp[a] = makeNumber(a - 1) + makeNumber(a - 2) + makeNumber(a - 3);
	}

	private static void initInput() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			T = Integer.parseInt(br.readLine());
			arr = new int[T];
			for (int i = 0; i < T; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			dp = new int[12];
			dp[0] = dp[1] = 1;
		} catch (NumberFormatException | IOException e) {
		}

	}

}
