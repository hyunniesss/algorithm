package silver5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1316_Main {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 0;
		boolean[] alpha;
		try {
			int T = Integer.parseInt(br.readLine());
			while (T-- > 0) {
				alpha = new boolean[26];
				boolean flag = true;
				char[] input = br.readLine().toCharArray();
				char pref = input[0];
				for (char c : input) {
					if (alpha[c - 'a']) {
						flag = false;
						break;
					}
					if (pref == c) {
						continue;
					} else {
						alpha[pref - 'a'] = true;
						pref = c;
					}
				}
				N = flag ? N + 1 : N;
			}
		} catch (Exception e) {
		}
		System.out.println(N);

	}

}
