package silver4.B1026;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_timeout {
	
	static int N;
	static int[] A, B;
	static boolean[] check;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		B = new int[N];
		check = new boolean[N];
		StringTokenizer a=new StringTokenizer(br.readLine()," ");
		StringTokenizer b=new StringTokenizer(br.readLine()," ");
		for(int n=0;n<N;n++) {
			A[n] = Integer.parseInt(a.nextToken());
			B[n] = Integer.parseInt(b.nextToken());
		}	// end input
		
		permu(0, 0);
		System.out.println(min);
		
	}

	private static void permu(int cnt, int sum) {
		if(sum >= min) {
			return;
		}

		if(cnt==N) {
			min = Math.min(sum , min);
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(!check[i]) {
				check[i] = true;
				permu(cnt+1, sum + A[i] * B[cnt]);
				check[i] = false;
			}
		}
	}

}
