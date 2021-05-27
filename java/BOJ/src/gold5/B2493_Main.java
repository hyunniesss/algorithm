package gold5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2493_Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Stack<int[]> stack = new Stack<int[]>();

		StringTokenizer str = new StringTokenizer(br.readLine(), " ");

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int next = Integer.parseInt(str.nextToken());
			if (stack.isEmpty()) {
				sb.append("0 ");
				stack.push(new int[] { next, i + 1 });
				continue;
			}
			while (!stack.isEmpty() && stack.peek()[0] < next) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				sb.append("0 ");
			} else {
				sb.append(stack.peek()[1] + " ");
			}
			stack.push(new int[] { next, i + 1 });
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));// 선언

		bw.write(sb.toString());
		bw.flush();

	}

}
