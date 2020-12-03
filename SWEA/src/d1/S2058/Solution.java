package d1.S2058;

import java.util.Scanner;

/**
 * 
 * @author hyunhee
 * 하나의 자연수를 입력 받아 각 자릿수의 합을 계산하는 프로그램을 작성하라.
 */

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		int answer = 0;
		for(char c : input.toCharArray()) {
			answer += (c-'0');
		}
		System.out.println(answer);
		
		sc.close();
		
	}

}
