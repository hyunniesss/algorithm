package bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10988_Main {

	public static void main(String[] args) {
		char[] word = initInput();
		int i = 0, j = word.length - 1;
		while (i <= j && word[i] == word[j]) {
			i++;
			j--;
		}
		System.out.println(i > j ? 1 : 0);
	}

	private static char[] initInput() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		try {
			input = br.readLine();
		} catch (IOException e) {
		}
		return input.toCharArray();
	}

}
