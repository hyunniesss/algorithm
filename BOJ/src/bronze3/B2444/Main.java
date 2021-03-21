package bronze3.B2444;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		// 위쪽 별
		for (int n = 1; n <= N; n++) { // 별 갯수
			// 왼쪽 별
			for (int i = N; i > n; i--) {
				bw.write(" ");
			}
			for (int i = 0; i < n; i++) {
				bw.write("*");
			}
			// 오른쪽 별
			for (int i = 1; i < n; i++) {
				bw.write("*");
			}

			bw.newLine();
		}

		// 아래쪽 별
		for (int n = N - 1; n >= 1; n--) { // 별 갯수
			// 왼쪽 별
			for (int i = N; i > n; i--) {
				bw.write(" ");
			}
			for (int i = 0; i < n; i++) {
				bw.write("*");
			}
			for (int i = 1; i < n; i++) {
				bw.write("*");
			}
			bw.newLine();

		}

		bw.flush();
	}

}
