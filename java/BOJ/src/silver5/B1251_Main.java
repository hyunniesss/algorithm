package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1251_Main {

	static String s;
	static int LEN;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		initInput();
		arr = new int[2];
		combi(0, 0, LEN - 2);

		System.out.println(answer);
	}

	static String answer;

	private static void combi(int cnt, int cur, int N) {
		if (cnt == 2) {
			StringBuilder temp = new StringBuilder(s.substring(0, arr[0] + 1)).reverse();
			if (temp.charAt(0) <= answer.charAt(0)) {
				temp.append(new StringBuilder(s.substring(arr[0] + 1, arr[1] + 1)).reverse());
				temp.append(new StringBuilder(s.substring(arr[1] + 1)).reverse());
				if (answer.compareTo(temp.toString()) > 0) {
					answer = temp.toString();
				}

			}
			return;
		}

		for (int i = cur; i <= N; i++) {
			arr[cnt] = i;
			combi(cnt + 1, i + 1, N);
		}
	}

	private static void initInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			s = br.readLine();
			answer = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
			LEN = s.length();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
