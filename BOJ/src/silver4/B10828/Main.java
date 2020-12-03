package silver4.B10828;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int N;
//	static List<Integer> stack = new ArrayList<>();
	static Stack<Integer> stack = new Stack<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			switch (st.nextToken()) {
			case "push":
				stack.add(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if (stack.size() > 0) {
					sb.append(stack.pop());
				} else {
					sb.append(-1);
				}
				sb.append("\n");
				break;
			case "size":
				sb.append(stack.size()).append("\n");
				break;
			case "empty":
				sb.append(stack.isEmpty() ? 1 : 0).append("\n");
				break;
			case "top":
				if (stack.size() > 0) {
					sb.append(stack.peek());
				} else {
					sb.append(-1);
				}
				sb.append("\n");
				break;
			}
		}

		System.out.println(sb);
		
	}

}
