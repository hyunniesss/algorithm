package silver4.B10989;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2 {
	
	public static void main(String[] args) throws Exception {
		int[] data = new int[20001];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int n=0;n<N;n++)
			data[Integer.parseInt(br.readLine())+10000]++;
		StringBuilder sb = new StringBuilder();
		for(int idx=0,i=0;idx<N && i<20001;i++) {
			if(data[i]!=0) {
				while(data[i]!=0) {
					sb.append((i-10000)+"\n");
					data[i]--;
				}
			}
		}
		System.out.println(sb.toString());
	}

}
