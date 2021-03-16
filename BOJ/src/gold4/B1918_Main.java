package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1918_Main {

	static String[] operation = { "*/+-", "*/" };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();

		StringBuilder sb = new StringBuilder();
		Stack<Character> op = new Stack<>();
		for (int i = 0; i < input.length; i++) {
			if (input[i] >= 'A' && input[i] <= 'Z') { // 피연산자면 그냥 넣어
				sb.append(input[i]);
			} else if (input[i] == '(') { // 열린 괄호는 스택에
				op.push(input[i]);
			} else if (input[i] == ')') { // 닫힌 괄호면 열린괄호 나올 때까지 스택에서 빼
				while (op.peek() != '(') {
					sb.append(op.pop());
				}
				op.pop();
			} else { // 연산자이면
				switch (input[i]) {
				case '+':
					while (op.size() > 0 && operation[0].contains(op.peek() + "")) {
						sb.append(op.pop());
					}
					op.push(input[i]);
					break;
				case '-':
					while (op.size() > 0 && operation[0].contains(op.peek() + "")) {
						sb.append(op.pop());
					}
					op.push(input[i]);
					break;
				case '*':
					while (op.size() > 0 && operation[1].contains(op.peek() + "")) {
						sb.append(op.pop());
					}
					op.push(input[i]);
					break;
				case '/':
					while (op.size() > 0 && operation[1].contains(op.peek() + "")) {
						sb.append(op.pop());
					}
					op.push(input[i]);
					break;
				}
			}
		}

		while (!op.isEmpty()) {
			sb.append(op.pop());
		}

		System.out.println(sb);

	}

}
