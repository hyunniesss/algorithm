package silver1.B1052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(str.nextToken());
		int K = Integer.parseInt(str.nextToken());
		int answer = 0;
		while (true) {
			int count = 0;
			int temp = N;
//			int min = Integer.MAX_VALUE;
			for (int i = 0; i < 32; i++) {
				if ((1 << i) > N) {
					break;
				}
				if ((1 << i & N) != 0) {
//					min = Math.min(min, 1<<i);
					count++;
				}
			}
			if (count <= K) {
				System.out.println(answer);
				break;
			} else {
				answer += N & (-N);	// 비트가 1인 위치 중 가장 작은 숫자
				N += N & (-N);
			}
		}

	}

}
