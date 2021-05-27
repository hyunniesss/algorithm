package bronze3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B2439_Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=N;i++) {	// 줄 수 = 별 갯수
			for(int j=N;j>i;j--) {	// 줄마다의 띄어쓰기 개수
				bw.write(" ");
			}
			for(int j=0;j<i;j++) {	// 별 갯수
				bw.write("*");
			}
			bw.newLine();
		}
		bw.flush();
		
	}

}
