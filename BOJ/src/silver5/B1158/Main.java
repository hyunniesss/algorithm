package silver5.B1158;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static boolean[] check;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(str.nextToken());
		check = new boolean[N + 1];
		K = Integer.parseInt(str.nextToken());
		int k = 1;
		int l = 0;
		for (int i = 1; i <= N; i++) {
			if(l==N) {
				break;
			}
			if (!check[i]) {
				if (k == K) {
					check[i] = true;
					k = 1;
					l++;
					sb.append(i+", ");
				} else {
					k++;
				}
			}
			if(i==N)
				i = 0;
//			if(sb.length()==3*N)
//				break;
		}
		System.out.println("<"+sb.substring(0,sb.length()-2)+">");

	}
}
