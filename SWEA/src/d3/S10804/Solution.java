package d3.S10804;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * @author hyunhee
 * ‘b’, ‘d’, ‘p’, ‘q’로 이루어진 문자열
 * 거울에 비친 결과 : b->d, d->b, p->q, q->p
 */

public class Solution {
	
	static int T;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			sb.append("#").append(tc).append(" ");
			String input = br.readLine();
			StringBuilder temp = new StringBuilder();
			for(char c : input.toCharArray()) {
				switch(c) {
				case 'b':
					temp.append("d");
					break;
				case 'd':
					temp.append("b");
					break;
				case 'p':
					temp.append("q");
					break;
				case 'q':
					temp.append("p");
					break;
				}
			}
			sb.append(temp.reverse()).append("\n");
		}
		System.out.println(sb);
	}

}
