package d1.S2050;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * @author hyunhee
 * 알파벳으로 이루어진 문자열을 입력 받아 각 알파벳을 1부터 26까지의 숫자로 변환하여 출력하라.
 */

public class Solution {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] input = br.readLine().toCharArray();
		StringBuilder sb = new StringBuilder();
		for(char c : input) {
			sb.append(c>='a' ? (c+1)-'a' : (c+1)-'A').append(" ");
		}
		System.out.println(sb);
	}

}
