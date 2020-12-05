package silver5.B11651;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] input;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		input = new int[N][2];
		
		for(int n=0;n<N;n++) {
			StringTokenizer str = new StringTokenizer(br.readLine()," ");
			for(int m=0;m<2;m++) {
				input[n][m] = Integer.parseInt(str.nextToken());
			}
		}
		
		Arrays.sort(input, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
			
		});
		
		for(int n=0;n<N;n++) {
			for(int m=0;m<2;m++) {
				sb.append(input[n][m]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
