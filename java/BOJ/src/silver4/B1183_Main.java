package silver4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1183_Main {
	// 기다리는 시간 최소 -> 모든 약속을 T시간씩 미룸
	// A : 마법사 약속 시간, B : 마법사 도착 시간
	// 1 ≤ Ai, Bi ≤ 10^9
	// 1 ≤ N ≤ 50
	static int N;
	static int[] A, B, time;

	public static void main(String[] args) {
		initInput();
		solve();

	}

	private static void solve() {
		if (N % 2 == 0) {
			time = new int[N];
			for (int i = 0; i < N; i++) {
				time[i] = B[i] - A[i];
			}
			Arrays.sort(time);
			System.out.println(time[N / 2] - time[N / 2-1] + 1);
		} else {
			System.out.println(1);
		}
	}

	private static void initInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		try {
			N = Integer.parseInt(br.readLine());
			A = new int[N];
			B = new int[N];
			for (int i = 0; i < N; i++) {
				str = new StringTokenizer(br.readLine(), " ");
				A[i] = Integer.parseInt(str.nextToken());
				B[i] = Integer.parseInt(str.nextToken());
			}
		} catch (Exception e) {
		}
	}

}