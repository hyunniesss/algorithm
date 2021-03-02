package bronze1.B14696;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer str = null;

		int N = Integer.parseInt(br.readLine()); // 라운드 수

		while (N-- > 0) {

			int[][] map = new int[2][4]; // [0] : A가 가진 카드 수, [1] : B가 가진 카드 수

			str = new StringTokenizer(br.readLine(), " ");
			str.nextToken();

			while (str.hasMoreTokens()) {
				map[0][Integer.parseInt(str.nextToken()) - 1]++;
			}

			str = new StringTokenizer(br.readLine(), " ");
			str.nextToken();

			while (str.hasMoreTokens()) {
				map[1][Integer.parseInt(str.nextToken()) - 1]++;
			}

			int idx = 3;
			while (idx >= 0 && map[1][idx] == map[0][idx]) { // 무승부인동안
				idx--;
			}

			if (idx < 0) { // 이건 무승부
				bw.write("D");
			} else {
				bw.write(map[1][idx] > map[0][idx] ? "B" : "A");
			}

			bw.newLine();

		}

		bw.flush();

	}

}
