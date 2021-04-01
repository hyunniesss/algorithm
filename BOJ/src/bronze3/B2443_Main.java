package bronze3;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class B2443_Main {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

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

		bw.flush();

	}

}
