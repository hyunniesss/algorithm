package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1158_Main_Array {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(str.nextToken());
		int K = Integer.parseInt(str.nextToken());
		boolean[] check = new boolean[N + 1];
		StringBuilder sb = new StringBuilder("<");

		int count = 0, k = 0, index = 1;
		for (; index <= N; index = index == N ? 1 : index + 1) {
			if (!check[index]) {
				k++;
				if (k == K) {
					check[index] = true;
					sb.append(index).append(", ");
					count++;
					k = 0;
				}
			}
			if (count == N) {
				break;
			}
		}
		String answer = sb.toString();
		System.out.println(answer.substring(0, answer.length() - 2) + ">");
	}

}
