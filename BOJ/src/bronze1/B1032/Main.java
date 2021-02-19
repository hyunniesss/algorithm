package bronze1.B1032;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] files = new char[N][];
		for (int n = 0; n < N; n++) {
			files[n] = br.readLine().toCharArray();
		}
		StringBuilder sb = new StringBuilder();
		for (int m = 0; m < files[0].length; m++) {
			char cur = files[0][m];
			boolean flag = true;
			for (int n = 1; n < N; n++) {
				if(files[n][m]==cur) {
					continue;
				} else {
					sb.append("?");
					flag = false;
					break;
				}
			}
			if(flag) {
				sb.append(cur);
			}
		}
		System.out.println(sb);

	}

}
