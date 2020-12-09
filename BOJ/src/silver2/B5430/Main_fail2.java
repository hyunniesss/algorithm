package silver2.B5430;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_fail2 {

	static int T, N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			char[] punc = br.readLine().toCharArray();
			N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer str = new StringTokenizer(br.readLine(), "[,]");
			for (int n = 0; n < N; n++) {
				arr[n] = Integer.parseInt(str.nextToken());
			}
			int front = 0, rear = N - 1;
			boolean flag = true; // font
			boolean error = false;
			for (char c : punc) {
				if (front > rear) {
					System.out.println("error");
					error = true;
					break;
				}
				switch (c) {
				case 'R':
					flag = !flag;
					break;
				case 'D':
					if (flag) {
						arr[front] = 0;
						front++;
					} else {
						arr[rear] = 0;
						rear--;
					}
				}
			}
			if (!error) {
				if (!flag) {
					int[] temp = new int[N];
					for(int n=0;n<N;n++) {
						temp[n] = arr[N-1-n];
					}
					arr = Arrays.copyOfRange(temp, 0, N);
				}
				StringBuilder temp = new StringBuilder(Arrays.toString(arr).replaceAll(" ", ""));
				temp = new StringBuilder(temp.toString().replaceAll(",0", ""));
				temp = new StringBuilder(temp.toString().replaceAll("0,", ""));
				System.out.println(temp);
			}
		}

	}

}
