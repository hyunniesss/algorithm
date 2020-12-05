package silver5.B11650;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2_memory {
	
	static final int LEN = 200001;
	
	static boolean[][] map = new boolean[LEN][LEN];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("MAIN");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new StringReader(src));
		
		int N = Integer.parseInt(br.readLine());
		while( N-- > 0) {
			System.out.println(N);
			StringTokenizer str = new StringTokenizer(br.readLine()," ");
			map[Integer.parseInt(str.nextToken())+100000][Integer.parseInt(str.nextToken())+100000] = true;
		}

		for(int y=0;y<LEN;y++) {
			for(int x=0;x<LEN;x++) {
				if(map[x][y]) {
					sb.append(x-100000).append(" ").append(y-100000).append("\n");
				}
			}
		}
		
		System.out.println(sb);
		
	}
	
	static final String src = "5\r\n" + 
			"3 4\r\n" + 
			"1 1\r\n" + 
			"1 -1\r\n" + 
			"2 2\r\n" + 
			"3 3";

}
