package silver5.B1292;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		int[] arr = new int[1001];
		int count = 1, number = 1;
		for (int i = 1; i < arr.length; i++) {
			arr[i] = number;
			if (--count == 0) {
				count = ++number;
			}
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(str.nextToken());
		int b = Integer.parseInt(str.nextToken());
		int answer = 0;
		for (int i = a; i <= b; i++) {
			answer += arr[i];
		}

		System.out.println(answer);

	}

}
