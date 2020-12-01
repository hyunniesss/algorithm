package d3.S10912;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			sb.append("#").append(tc).append(" ");
			
			char[] input = br.readLine().toCharArray();
			boolean[] check = new boolean[26];
			for(int i=0;i<input.length;i++) {
				check[input[i]-'a'] = !check[input[i]-'a'];
			}
			boolean flag = false;
			for(int i=0;i<26;i++) {
				if(check[i]) {
					sb.append((char)(i+'a'));
					flag = true;
				}
			}
			if(!flag)
				sb.append("Good");
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
//	static String src = "6\r\n" + 
//			"xxyyzz\r\n" + 
//			"yc\r\n" + 
//			"aaaab\r\n" + 
//			"bca\r\n" + 
//			"ppzqq\r\n" + 
//			"qnwerrewmq\r\n";

}
