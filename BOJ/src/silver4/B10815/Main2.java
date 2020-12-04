package silver4.B10815;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

	static boolean[] number = new boolean[200000001];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		StringTokenizer str = new StringTokenizer(br.readLine()," ");
		while(str.hasMoreTokens()) {
			number[Integer.parseInt(str.nextToken())+10000000] = true;
		}
		br.readLine();
		str = new StringTokenizer(br.readLine()," ");
		while(str.hasMoreTokens()) {
			if(number[Integer.parseInt(str.nextToken())+10000000]) {
				sb.append(1).append(" ");
			} else {
				sb.append(0).append(" ");
			}
		}
		System.out.println(sb);
	}

}
