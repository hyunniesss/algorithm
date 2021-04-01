package bronze3.B2490;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static final int T = 3;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer str = null;

		for (int i = 0; i < T; i++) {
			int[] stick = new int[2]; // 0 : 배, 1 : 등
			str = new StringTokenizer(br.readLine(), " ");
			while (str.hasMoreTokens()) {
				stick[Integer.parseInt(str.nextToken())]++;
			}

			switch (stick[0]) {
			case 0:
				bw.write("E");
				break;
			case 1:
				bw.write("A");
				break;
			case 2:
				bw.write("B");
				break;
			case 3:
				bw.write("C");
				break;
			case 4:
				bw.write("D");
			}
			
			bw.newLine();

		}
		bw.flush();

	}

}
