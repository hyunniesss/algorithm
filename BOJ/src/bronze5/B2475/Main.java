package bronze5.B2475;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		int answer = 0;
		while (str.hasMoreTokens()) {
			answer += (int) Math.pow(Integer.parseInt(str.nextToken()), 2);
			answer %= 10;
		}
		bw.write(answer+"");
		bw.flush();
	}
}