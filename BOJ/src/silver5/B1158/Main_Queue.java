package silver5.B1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_Queue {

	static Queue<Integer> queue = new LinkedList<Integer>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(str.nextToken());
		int K = Integer.parseInt(str.nextToken());
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		int k = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while (!queue.isEmpty()) {
			k++;
			int temp = queue.poll();
			if (k == K) {
				sb.append(temp).append(", ");
				k = 0;
			} else {
				queue.offer(temp);
			}
		}
		String answer = sb.toString();
		System.out.println(answer.substring(0, answer.length() - 2) + ">");

	}

}
