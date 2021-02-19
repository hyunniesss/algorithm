package silver2.B1541;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] number;
	static String[] op;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		StringTokenizer nums = new StringTokenizer(input, "+-");
		StringTokenizer operation = new StringTokenizer(input, "0123456789");
		number = new int[nums.countTokens()];
		op = new String[operation.countTokens()];

		for (int i = 0, len = number.length; i < len; i++) {
			number[i] = Integer.parseInt(nums.nextToken());
		}

		for (int i = 0, len = op.length; i < len; i++) {
			op[i] = operation.nextToken();
		}

		int answer = number[0], temp = 0;
		int idx = 0;
		while (idx < op.length && "+".equals(op[idx])) {
			answer += number[++idx];
		}
		for (int i = idx; i < op.length; i++) {
			if ("-".equals(op[i])) {
				answer -= temp;
				temp = number[i + 1];
			} else {
				temp += number[i + 1];
			}
		}
		System.out.println(answer - temp);

	}

}
