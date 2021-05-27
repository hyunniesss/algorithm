package bronze3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class B2445_Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		// 위쪽 별
		for (int n = 1; n <= N; n++) {
			// 1. 왼쪽 별 모양
			for (int j = 0; j < n; j++) {
				bw.write("*");
			}
			for (int j = 0; j < N - n; j++) {
				bw.write(" ");
			}

			// 2. 오른쪽 별 모양
			for (int j = 0; j < N - n; j++) {
				bw.write(" ");
			}
			for (int j = 0; j < n; j++) {
				bw.write("*");
			}
			bw.newLine();
		}

		// 아래쪽 별
		for (int n = N-1; n > 0; n--) {
			// 1. 왼쪽 별 모양
			for (int j = 0; j < n; j++) {
				bw.write("*");
			}
			for (int j = 0; j < N - n; j++) {
				bw.write(" ");
			}

			// 2. 오른쪽 별 모양
			for (int j = 0; j < N - n; j++) {
				bw.write(" ");
			}
			for (int j = 0; j < n; j++) {
				bw.write("*");
			}
			bw.newLine();
		}
		
		bw.flush();

	}

}
