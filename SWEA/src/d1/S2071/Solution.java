package d1.S2071;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author hyunhee
 * 10개의 수를 입력 받아, 평균값을 출력하는 프로그램을 작성하라.
 * 소수점 첫째 자리에서 반올림한 정수 ( Math.round )
 *  0 이상 10000 이하의 정수 : 10^4 * 10 = 10^5 ( Integer 범위 내 )
 */

public class Solution {
	
	static int T;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
	
		for(int tc=1;tc<=T;tc++) {
			sb.append("#").append(tc).append(" ");	// 출력 형태
			int total = 0;
			StringTokenizer str = new StringTokenizer(br.readLine()," ");
			
			while(str.hasMoreTokens()) {
				total += Integer.parseInt(str.nextToken());
			}
			
			sb.append(Math.round((float) total/10)).append("\n");
		}
		
		System.out.println(sb); // 출력 한번에 처리
		
	}

}
