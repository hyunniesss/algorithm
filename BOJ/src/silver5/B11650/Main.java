package silver5.B11650;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * @author hyunhee
 * Arrays.sort에서 Comparator를 쓸 수 있는지 묻는 문제
 */

public class Main {
	
	static int N;
	static int[][] input;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N][2];
		
		while(N-- > 0) {
			StringTokenizer str = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<2;i++) {
				input[N][i] = Integer.parseInt(str.nextToken());
			}
		}
		Arrays.sort(input, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
			
		});
		
		for(int n=0;n<input.length;n++) {
			for(int m=0;m<2;m++) {
				sb.append(input[n][m]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
