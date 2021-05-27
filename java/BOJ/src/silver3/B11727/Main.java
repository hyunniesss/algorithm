package silver3.B11727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

//		String src = "12";

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new StringReader(src));
		int N = Integer.parseInt(br.readLine());

		if (N == 1) {
			System.out.println(1);
			return;
		}
		if (N == 2) {
			System.out.println(3);
			return;
		}

		int[] memoi = new int[N + 1];
		memoi[1] = 1;
		memoi[2] = 3;
		for (int n = 3; n <= N; n++) {
			memoi[n] = ((2 * memoi[n - 2]) + memoi[n - 1]) % 10007;
		}
		System.out.println(memoi[N]);

	}

}
