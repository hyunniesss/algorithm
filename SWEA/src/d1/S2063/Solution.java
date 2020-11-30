package d1.S2063;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author hyunhee 
 * 중간값은 통계 집단의 수치를 크기 순으로 배열 했을 때 전체의 중앙에 위치하는 수치 
 * 입력으로 N 개의 점수가 주어졌을 때, 중간값을 출력 
 * 문제 : Arrays.sort를 쓸 수 있느냐?
 */

public class Solution {

	static int N;
	static int[] input;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		input = new int[N];
		
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		for(int n=0;n<N;n++) {
			input[n] = Integer.parseInt(str.nextToken());
		}
		Arrays.sort(input);
		System.out.println(input[N/2]);
	}

}
