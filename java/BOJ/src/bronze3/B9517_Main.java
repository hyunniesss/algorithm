package bronze3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9517_Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		int K = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int count = 210;
		int answer = -1;
		for (int i = 0; i < N; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			count -= Integer.parseInt(str.nextToken());
			if (count <= 0 && answer == -1) {
				answer = K;
			}
			if ("T".equals(str.nextToken())) {
				K = ++K == 9 ? 1 : K;
			}
		}
		System.out.println(answer);
	}

}
