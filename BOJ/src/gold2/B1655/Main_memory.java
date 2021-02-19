package gold2.B1655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_memory {
	
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] array = new int[N/2+1];
		Arrays.fill(array, INF);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N/2;i++) {
			array[i] = Integer.parseInt(br.readLine());
			Arrays.sort(array);
			sb.append(array[i/2]).append("\n");
		}
		for(int i=N/2;i<N;i++) {
			array[array.length-1] = Integer.parseInt(br.readLine());
			Arrays.sort(array);
			sb.append(array[i/2]).append("\n");
		}
		System.out.println(sb);
		
	}

}
