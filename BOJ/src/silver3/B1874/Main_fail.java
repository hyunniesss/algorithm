package silver3.B1874;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main_fail {

	static StringBuilder answer = new StringBuilder();
	static Stack<Integer> st = new Stack<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int n = 1;
		boolean flag = true;
		for (int i = 1; i < N; i++) {
			if (!flag) {
				br.readLine();
			} else {
				int input = Integer.parseInt(br.readLine());
				while (st.isEmpty() || st.peek() != input) {
					st.add(n++);
					answer.append("+\n");
					if (n > N + 1) {
						flag = false;
						break;
					}
				}
				if (flag) {
					st.pop();
					answer.append("-\n");
				} else {
					answer = new StringBuilder("NO");
				}
			}
		}

		System.out.println(answer);

	}

}
