package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B11060_Main {

	static int[] map, dp;
	static int N;

	public static void main(String[] args) {

		initInput();

		int answer = goBFS();
		System.out.println(answer);
	}

	private static int goBFS() {
//		Queue<Integer> queue = new LinkedList<>();
//		queue.offer(0);
		dp[0] = 0;
//		while(!queue.isEmpty()) {
//			int cur = queue.poll();
//			for(int i=1;i<=map[cur];i++) {
//				if(cur+i<N && dp[cur+i]==-1) {	// 방문 전이면
//					dp[cur+i] = dp[cur]+1;
//					queue.offer(cur+i);
//				}
//			}
//		}

		for (int i = 0; i < N; i++) {
			if (dp[i] == -1) {
				continue;
			}
			for (int j = 1; j <= map[i]; j++) {
				if (i + j < N && dp[i + j] == -1) {
					dp[i + j] = dp[i] + 1;
				}
			}
		}

		return dp[N - 1];

	}

	private static void initInput() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		try {
			N = Integer.parseInt(br.readLine());
			map = new int[N];
			str = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				map[i] = Integer.parseInt(str.nextToken());
			}

			dp = new int[N];
			Arrays.fill(dp, -1);
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}

}
