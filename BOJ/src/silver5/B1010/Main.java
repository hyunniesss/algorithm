package silver5.B1010;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author hyunhee 
 * nCr = n! / r!(n-r)! = n-1Cr-1 + n-1Cr : 파스칼의 삼각형
 * memoization 써서 풀면 될듯
 *<입력> 
 *1) 입력의 첫 줄에는 테스트 케이스의 개수 T 
 *2) 강의 서쪽과 동쪽에 있는 사이트의 개수 정수 N, M (0 < N ≤ M < 30) 
 *<출력> 
 *각 테스트 케이스에 대해 주어진 조건하에 다리를 지을 수 있는 경우의 수를 출력
 *
 */

public class Main {

	static int T, N, R;
	static StringBuilder sb = new StringBuilder();
	static long[][] memoi;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer str = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(str.nextToken());
			N = Integer.parseInt(str.nextToken());
			memoi = new long[N + 2][N + 2];
			memoi[1][1] = 1;
			memoi[1][2] = 1;
			for (int n = 2; n <= N; n++) {
				for (int r = 1; r <= R + 1; r++) {
					memoi[n][r] = memoi[n - 1][r - 1] + memoi[n - 1][r];
				}
			}
			sb.append(memoi[N][R + 1]).append("\n");
		}

		System.out.println(sb);

	}

}
