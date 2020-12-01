package d1.S2068;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author hyunhee 
 * 10개의 수를 입력 받아, 그 중에서 가장 큰 수를 출력하는 프로그램을 작성하라.
 */

public class Solution {

	static int T;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			int max = -1;
			StringTokenizer str = new StringTokenizer(br.readLine().trim(), " ");
			while (str.hasMoreTokens()) {
				int temp = Integer.parseInt(str.nextToken());
				max = max > temp ? max : temp;
			}

			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}

}
