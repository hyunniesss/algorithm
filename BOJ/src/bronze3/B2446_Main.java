package bronze3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B2446_Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int count = 2 * (N - i) - 1;
			for (int j = 0; j < i; j++) {
				bw.write(" ");
			}
			for (int j = 0; j < count; j++) {
				bw.write("*");
			}
			bw.newLine();
		}
		for (int i = N - 2; i >= 0; i--) {
			int count = 2 * (N - i) - 1;
			for (int j = 0; j < i; j++) {
				bw.write(" ");
			}
			for (int j = 0; j < count; j++) {
				bw.write("*");
			}
			bw.newLine();
		}

		bw.flush();

	}

}
