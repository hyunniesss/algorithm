package silver2.B2504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	static String score = "  )]";

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		Stack<String> stack = new Stack<>();
		for (int i = 0; i < input.length; i++) {

			if (input[i] == '(') {
				stack.push(")");
			} else if (input[i] == '[') {
				stack.push("]");
			} else {
				if (stack.isEmpty()) {
					System.out.println(0);
					return;
				}
				if (stack.peek().equals(input[i] + "")) {
					stack.pop();
					stack.push(score.indexOf(input[i]) + "");
				} else if (score.contains(stack.peek())) {
					System.out.println(0);
					return;
				} else {
					int num = 0;
					while (!stack.isEmpty() && !score.contains(stack.peek())) {
						num += Integer.parseInt(stack.pop());
					}
					if (stack.isEmpty()) {
						System.out.println(0);
						return;
					}
					if (stack.peek().equals(input[i] + "")) {
						stack.pop();
						num *= score.indexOf(input[i]);
						stack.push(num + "");
					} else {
						System.out.println(0);
						return;
					}
				}
			}

		}
		int answer = 0;
		while (!stack.isEmpty()) {
			try {
				answer += Integer.parseInt(stack.pop());
			} catch (NumberFormatException e) {
				System.out.println(0);
				return;
			}
		}

		System.out.println(answer);

	}

}
