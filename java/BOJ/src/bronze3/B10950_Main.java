package bronze3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B10950_Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer str = null;

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {

			str = new StringTokenizer(br.readLine(), " ");
			int answer = Integer.parseInt(str.nextToken()) + Integer.parseInt(str.nextToken());
			bw.write(answer + "");
			bw.newLine();

		}
		bw.flush();

	}
}
