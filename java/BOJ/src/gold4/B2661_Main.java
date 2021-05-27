package gold4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2661_Main {

	static int N;
	static String answer = "";

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		makeNumber();

	}

	private static void makeNumber() {
		
		if (answer.length() == N) {
			System.out.println(answer);
			System.exit(0);
		}
		for (int i = 1; i < 4; i++) {
			answer += (i + "");
			if (test()) {
				makeNumber();
			}
			answer = answer.substring(0, answer.length() - 1);

		}

	}

	private static boolean test() {
		int len = answer.length();
		for (int i = 1; i < answer.length() / 2 + 1; i++) {
			String prev = answer.substring(len - i - i, len - i);
			String next = answer.substring(len - i);
			if (next.equals(prev)) {
				return false;
			}
		}
		return true;
	}

}
