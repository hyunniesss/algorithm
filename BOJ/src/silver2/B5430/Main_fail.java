package silver2.B5430;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_fail {

	static int T;
	static Deque<Integer> deque = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			deque.clear();
			StringBuilder sb = new StringBuilder();
			char[] punc = br.readLine().toCharArray();
			int N = Integer.parseInt(br.readLine());
			StringTokenizer str = new StringTokenizer(br.readLine(), "[,]");
			while (str.hasMoreTokens()) {
				deque.add(Integer.parseInt(str.nextToken()));
			}

			boolean flag = true; // 얘가 idx = 0
			boolean error = false;

			for (char c : punc) {
				if (deque.size() == 0) {
					System.out.println("error");
					error = true;
					break;
				}
				if (c == 'R') {
					flag = !flag;
				} else {
					if (flag)
						deque.pollFirst();
					else
						deque.pollLast();
				}
			}
			if (!error) {
				sb.append("[");
				if (flag) {
					while (deque.size() > 0) {
						sb.append(deque.pollFirst() + ",");
					}
				} else {
					while (deque.size() > 0) {
						sb.append(deque.pollLast() + ",");
					}
				}
				sb = new StringBuilder(sb.substring(0, sb.length() - 1));
				sb.append("]");
				System.out.println(sb);
			}
		}

	}

}
