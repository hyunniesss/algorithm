package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1748_Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		long sum = 0L;

		for (int i = 0; i < input.length() - 1; i++) {
			long temp = (long) ((9 * Math.pow(10, i)) * (i + 1));
			sum += temp;
		}
		long temp = (long) ((Integer.parseInt(input) - Math.pow(10, input.length() - 1) + 1) * input.length());
		sum += temp;
		System.out.println(sum);
	}

}
