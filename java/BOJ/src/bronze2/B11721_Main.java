package bronze2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class B11721_Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = br.readLine();
		int i = 10;
		String tokens;
		for (; i < input.length(); i += 10) {
			tokens = input.substring(i - 10, i);
			bw.write(tokens);
			bw.newLine();
		}
		tokens = input.substring(i - 10);
		bw.write(tokens);
		bw.flush();
	}
}