package bronze3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B2441_Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int n=0;n<N;n++) {	// 몇 번째 줄인가
			
			for(int i=0;i<n;i++) {
				bw.write(" ");
			}
			for(int j=0;j<N-n;j++) {
				bw.write("*");
			}
			bw.newLine();
		}
		
		bw.flush();
	}

}
