package silver4.B4949;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	static StringBuilder answer = new StringBuilder();
	static Stack<Character> stack = new Stack<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		while (!input.equals(".")) {
			stack.clear();

			boolean flag = true;
			for (int i = 0; i < input.length(); i++) {
				switch (input.charAt(i)) {
				case '(':
					stack.add('(');
					break;
				case '[':
					stack.add('[');
					break;
				case ')':
					if (!stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
					} else {
						flag = false;
					}
					break;
				case ']':
					if (!stack.isEmpty() && stack.peek() == '[') {
						stack.pop();
					} else {
						flag = false;
					}
					break;
				}
				if (!flag) {
					break;
				}
			}
			answer.append(flag&&stack.isEmpty() ? "yes\n" : "no\n");
			input = br.readLine();
		}
		
		System.out.println(answer);
	}

}
