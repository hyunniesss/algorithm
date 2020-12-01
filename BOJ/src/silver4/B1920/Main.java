package silver4.B1920;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[] A;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer str = new StringTokenizer(br.readLine()," ");
		A = new int[N];
		for(int n=0;n<N;n++) {
			A[n] = Integer.parseInt(str.nextToken());
		}
		Arrays.sort(A);
		
		M = Integer.parseInt(br.readLine());
		str = new StringTokenizer(br.readLine()," ");
		for(int m=0;m<M;m++) {
			int temp = Integer.parseInt(str.nextToken());
			if(Arrays.binarySearch(A, temp)>-1) {
				sb.append(1).append("\n");
			} else {
				sb.append(0).append("\n");
			}
		}
		
		System.out.println(sb);
	}

}
