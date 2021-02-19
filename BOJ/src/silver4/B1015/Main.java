package silver4.B1015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Integer[] P = new Integer[N];
		int[][] A = new int[N][2];
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		for (int n = 0; n < N; n++) {
			A[n][0] = Integer.parseInt(str.nextToken());
			A[n][1] = n;
		}
		Arrays.sort(A, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}

		});
		int[] B = new int[N];
		for (int i = 0; i < N; i++) {
			B[A[i][1]] = i;
		}
		StringBuilder sb = new StringBuilder();
		for (int n = 0; n < N; n++) {
			sb.append(B[n]).append(" ");
		}
		System.out.println(sb);

	}

}
