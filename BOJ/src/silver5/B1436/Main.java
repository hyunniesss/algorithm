package silver5.B1436;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int index = 666;
		while (N > 0) {
			if ((index + "").contains("666")) {
				N--;
			}
			index++;
		}

		System.out.println(index - 1);

	}

}
