package silver3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1935_Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] number = new int[N];
		char[] input = br.readLine().toCharArray();	// 후위 표현식
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(br.readLine());	// 대응값
		} // end input

		Stack<Double> stack = new Stack<>();
		double val1, val2;
		for (int i = 0; i < input.length; i++) {
			switch (input[i]) {
			case '+':
				val2 = stack.pop();
				val1 = stack.pop();
				stack.push(val1 + val2);
				break;
			case '-':
				val2 = stack.pop();
				val1 = stack.pop();
				stack.push(val1 - val2);
				break;
			case '*':
				val2 = stack.pop();
				val1 = stack.pop();
				stack.push(val1 * val2);
				break;
			case '/':
				val2 = stack.pop();
				val1 = stack.pop();
				stack.push(val1 / val2);
				break;
			default:	// 'A'~'Z'
				stack.push((double) number[input[i] - 'A']);
			}
		}

		System.out.printf("%.2f", stack.pop());

	}

}
