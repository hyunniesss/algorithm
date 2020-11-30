package d1.S2070;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author hyunhee
 * 2개의 수를 입력 받아 크기를 비교하여 등호 또는 부등호를 출력하는 프로그램을 작성하라.
 */

public class Solution_BufferedReader {
	
	static int T;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			sb.append("#").append(tc).append(" ");
			
			StringTokenizer str = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			if(a<b)
				sb.append("<");
			else if(a==b)
				sb.append("=");
			else
				sb.append(">");
			
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
