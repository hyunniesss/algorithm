package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B9935_Main {

	static char[] target;
	static int LEN;

	public static void main(String[] args) {

		char[] input = initInput();
		String s = doBomb(input);
		System.out.println(s);
	}

	private static String doBomb(char[] input) {
		Stack<Character> stack = new Stack<>();
		for (char c : input) {
			if (stack.size() >= LEN - 1 && c == target[LEN - 1]) { // 앞의 길이가 타겟길이는 되야함
				int len = LEN - 2;
				char[] a = new char[LEN];
				a[LEN - 1] = c;
				while (len >= 0 && stack.peek() == target[len]) {
					a[len] = stack.pop();
					len--;
				}
				if (len < 0) { // 폭발
					continue;
				} else {
					for (int i = len + 1; i < LEN; i++) { // 폭발 못했으니 다시 채움
						stack.push(a[i]);
					}
				}
			} else {
				stack.push(c);
			}
		}
		StringTokenizer st = new StringTokenizer(stack.size() == 0 ? "FRULA" : stack.toString(), "[, ]");
		StringBuilder output = new StringBuilder();
		while (st.hasMoreTokens()) {
			output.append(st.nextToken());
		}

		return output.toString();

	}

	private static char[] initInput() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = null;
		try {
			input = br.readLine().toCharArray();
			target = br.readLine().toCharArray();
			LEN = target.length;
		} catch (IOException e) {
		}

		return input;

	}

}
