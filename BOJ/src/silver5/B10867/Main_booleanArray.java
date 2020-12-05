package silver5.B10867;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_booleanArray {
	
	static boolean[] check = new boolean[2001];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		StringTokenizer str = new StringTokenizer(br.readLine()," ");
		
		while(str.hasMoreTokens()) {
			check[Integer.parseInt(str.nextToken())+1000] = true;
		}
		for(int i=0;i<check.length;i++) {
			if(check[i]) {
				sb.append(i-1000).append(" ");
			}
		}
		System.out.println(sb);
	}

}
