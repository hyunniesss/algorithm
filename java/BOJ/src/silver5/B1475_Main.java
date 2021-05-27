package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1475_Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();

		int[] arr = new int[10];
		for (int i = 0; i < input.length; i++) {
			if (input[i] == '9') {
				arr[6]++;
			} else {
				arr[input[i] - '0']++;
			}
		}
		arr[6] = (arr[6] / 2) + (arr[6] % 2);
		Arrays.sort(arr);

		System.out.println(arr[9]);

	}

}
