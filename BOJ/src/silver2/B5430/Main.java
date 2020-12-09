package silver2.B5430;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int T;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			char[] punc = br.readLine().toCharArray();
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer str = new StringTokenizer(br.readLine(), "[,]");
			for (int n = 0; n < N; n++) {
				arr[n] = Integer.parseInt(str.nextToken());
			} // end input

			int front = 0, rear = N - 1;
			boolean flag = true; // true : front, false : rear
			boolean error = false;
			for (char c : punc) {
				switch (c) {
				case 'R':
					flag = !flag;
					break;
				case 'D':
					if (front > rear) {
						error = true;
						break;
					}
					if (flag) {
						front++;
					} else {
						rear--;
					}
					break;
				}
				if (error) {
					break;
				}
			}

			StringBuilder sb = new StringBuilder();
			if (error) {
				sb.append("error");
			} else {
				sb.append("[");
				if (flag) {
					for (; front <= rear; front++) {
						sb.append(arr[front] + ",");
					}
				} else {
					for (; front <= rear; rear--) {
						sb.append(arr[rear] + ",");
					}
				}
				if (sb.lastIndexOf(",") == sb.length() - 1) {
					sb = new StringBuilder(sb.substring(0, sb.length() - 1));
				}
				sb.append("]");
			}

			System.out.println(sb);

		}

	}

}
