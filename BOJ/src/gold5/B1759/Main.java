package gold5.B1759;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int L, C;
	static int totalCnt;
	static String[] data;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(str.nextToken());
		C = Integer.parseInt(str.nextToken());
		data = new String[C];
		str = new StringTokenizer(br.readLine(), " ");
		for (int c = 0; c < C; c++) {
			data[c] = str.nextToken();
		}
		Arrays.sort(data);

		combination("", 0);

	}

	private static void combination(String password, int cur) {
		if (password.length() == L) {
			int collection = 0;
			int consonant = 0;
			boolean flag = false;
			for (int i = 0; i < L; i++) {
				if ("aeiou".contains(password.charAt(i) + "")) {
					collection++;
					flag = true;
				} else {
					consonant++;
				}
			}
			if (flag && consonant >= 2) {
				System.out.println(password);
			}
			return;
		}

		for (int i = cur; i < C; i++) {
			combination(password + data[i], i + 1);
		}
	}

}
