package bronze2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B16968_Main {

	static char[] input;
	static int answer;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine().toCharArray();
		permutation(' ', 0);
		System.out.println(answer);
	}

	private static void permutation(char c, int cnt) {
		if (cnt == input.length) {
			answer++;
			return;
		}

		switch (input[cnt]) {
		case 'c':
			for (int i = 0; i < 26; i++) {
				if (c == (char) (i + 'a')) {
					continue;
				}
				permutation((char) (i + 'a'), cnt + 1);
			}
			break;
		case 'd':
			for (int i = 0; i < 10; i++) {
				if (c == (char) (i + '0')) {
					continue;
				}
				permutation((char) (i + '0'), cnt + 1);
			}
			break;
		}
	}

}
