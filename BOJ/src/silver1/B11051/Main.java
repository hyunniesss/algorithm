package silver1.B11051;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] paskal = new int[1001][1001];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		Arrays.fill(paskal[1], 1);
		int N = Integer.parseInt(str.nextToken());
		int K = Integer.parseInt(str.nextToken());
		System.out.println(combi(N,K));
	}

	private static int combi(int n, int k) {
		if(k==0) {
			return 1;
		}
		if(n<k) {
			return 0;
		}
		return combi(n-1, k)%1007 + combi(n-1, k-1)%1007;
		
	}


}
