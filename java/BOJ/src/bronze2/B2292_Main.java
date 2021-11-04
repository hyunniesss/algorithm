package bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2292_Main {

	public static void main(String[] args) {
		int N = 0;
		int pref = 1, cur = 2, i = 2;
		try {
			N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		} catch (NumberFormatException | IOException e) {
		}
		while (cur <= N) {
			pref = cur;
			cur = pref + 6 * (i - 1);
			i++;
		}

		System.out.println(i - 1);
	}

}
