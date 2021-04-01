package bronze2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B5622_Main {

	static String[] numbers = { "", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ" };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		int time = 0;

		for (int i = 0; i < input.length; i++) {
			for (int j = 2; j < 10; j++) {
				if (numbers[j].contains(input[i] + "")) {
					time += (1 + j);
					break;
				}
			}
		}
		
		System.out.println(time);

	}

}
