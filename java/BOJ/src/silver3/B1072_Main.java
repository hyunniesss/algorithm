package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1072_Main {

	static final int MAX = (int) Math.pow(10, 9);

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		do {
			StringTokenizer str = new StringTokenizer(input, " ");
			double X = Double.parseDouble(str.nextToken()); // 게임수
			double Y = Double.parseDouble(str.nextToken()); // 이긴수
			int Z = (int) Math.floor((Y * 100 / X));
			int add = 0;
			int temp;
			int left = 0, right = MAX;
			if (Z >= 99) {
				left = -1;
			} else {
				do {
					add = (left + right) / 2;
					temp = (int) Math.floor(((Y + add) * 100 / (X + add)));
					if (temp == Z) {
						left = add + 1;
					} else {
						right = add - 1;
					}
				} while (left <= right);
			}

			System.out.println(left);
			input = br.readLine();
		} while (input != null);

	}

}
