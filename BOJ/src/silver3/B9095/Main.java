package silver3.B9095;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int T;
	static int[] plus = new int[12];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		plus[0] = 1;
		plus[1] = 1;
		plus[2] = 2;
		for (int i = 3; i < 12; i++) {
			plus[i] = plus[i - 1] + plus[i - 2] + plus[i - 3];
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			sb.append(plus[Integer.parseInt(br.readLine())]).append("\n");
		}
		System.out.println(sb);

	}

}
