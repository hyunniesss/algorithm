package d3.S10761;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static Queue<Integer> Blue = new LinkedList<>();
	static Queue<Integer> Orange = new LinkedList<>();
	static Queue<String> Order = new LinkedList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			Blue.clear();
			Orange.clear();
			bw.write("#" + t + " ");

			StringTokenizer str = new StringTokenizer(br.readLine(), " ");
			str.nextToken();

			while (str.hasMoreTokens()) {
				String input = str.nextToken();
				switch (input) {
				case "B":
					Blue.offer(Integer.parseInt(str.nextToken()));
					break;
				case "O":
					Orange.offer(Integer.parseInt(str.nextToken()));
					break;
				}
				Order.offer(input);
			}
			int b = 1, o = 1, answer = 0;
			while (!Order.isEmpty()) { // 둘 다 비어있지 않을 때까지
				answer++;
				if (!Blue.isEmpty()) {
					int next = Blue.peek();
					if (next == b && "B".equals(Order.peek())) {
						Blue.poll();
						Order.poll();
					} else if (next > b) {
						b++;
					} else if (next < b) {
						b--;
					}
				} else {
					b = 0;
				}
				if (!Orange.isEmpty()) {
					int next = Orange.peek();
					if (next == o && "O".equals(Order.peek())) {
						Order.poll();
						Orange.poll();
					} else if (next > o) {
						o++;
					} else {
						o--;
					}
				}
			}
			bw.write(answer + "");
			bw.newLine();
		}

		bw.flush();
	}

}
