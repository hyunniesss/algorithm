package silver4.B10815;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] numbers;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		StringTokenizer str = new StringTokenizer(br.readLine()," ");
		for(int n=0;n<N;n++) {
			numbers[n] = Integer.parseInt(str.nextToken());
		}
		Arrays.sort(numbers);
//		M = Integer.parseInt(br.readLine());
		br.readLine();
		str = new StringTokenizer(br.readLine()," ");
		while(str.hasMoreTokens()) {
			int temp = Integer.parseInt(str.nextToken());
			sb.append((Arrays.binarySearch(numbers, temp)>-1) ? 1 : 0).append(" ");
		}
		
		System.out.println(sb);
	}
}
