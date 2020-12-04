package silver4.B10816;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static final int LEN = 20000001;
	static int[] number = new int[LEN];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		br.readLine();
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		while (str.hasMoreTokens()) {
			number[Integer.parseInt(str.nextToken()) + 10000000]++;
		}
		
		br.readLine();
		str = new StringTokenizer(br.readLine()," ");
		while(str.hasMoreTokens()) {
			sb.append(number[Integer.parseInt(str.nextToken())+10000000]).append(" ");
		}
		System.out.println(sb);
	}

}
