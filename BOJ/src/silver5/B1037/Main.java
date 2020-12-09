package silver5.B1037;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		for (int n = 0; n < N; n++) {
			input[n] = Integer.parseInt(str.nextToken());
		}
		Arrays.sort(input);
		if (input[0] == 1 && N == 2)
			System.out.println(input[N - 1] * input[N - 1]);
		else {
			System.out.println(input[0] * input[N - 1]);
		}
	}

}
