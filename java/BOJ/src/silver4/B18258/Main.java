package silver4.B18258;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Deque<Integer> deq = new LinkedList<>();
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			StringTokenizer str = new StringTokenizer(br.readLine(), " ");
			switch (str.nextToken()) {
			case "push":
				deq.offer(Integer.parseInt(str.nextToken()));
				break;
			case "pop":
				if (deq.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(deq.pollFirst()).append("\n");
				}
				break;
			case "size":
				sb.append(deq.size()).append("\n");
				break;
			case "empty":
				sb.append(deq.isEmpty() ? 1 : 0).append("\n");
				break;
			case "front":
				sb.append(deq.isEmpty() ? -1 : deq.peekFirst()).append("\n");
				break;
			case "back":
				sb.append(deq.isEmpty() ? -1 : deq.peekLast()).append("\n");
				break;
			}
		}
		System.out.println(sb);
	}

}