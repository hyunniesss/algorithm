package d3.S10726;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer str = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(str.nextToken());
			int M = Integer.parseInt(str.nextToken());
			StringBuilder bin = new StringBuilder();
			while(M>0) {
				bin.append(M%2);
				M/=2;
			}
			char[] an = bin.toString().toCharArray();
			int cur = 0;
			boolean flag = true;
			if(an.length>=N) {
				while(N-->0) {
					if(an[cur++]=='1')
						continue;
					flag = false;
					break;
				}
				sb.append(flag ? "ON" : "OFF");
			} else {
				sb.append("OFF");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
