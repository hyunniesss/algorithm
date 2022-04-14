package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1531_Main {

	static final int LEN = 100;
	static int[][] map = new int[LEN][LEN];
	static int M; // M개 이하

	static class Paper {
		int sx;
		int sy;
		int ex;
		int ey;

		public Paper(int sx, int sy, int ex, int ey) {
			this.sx = sx;
			this.sy = sy;
			this.ex = ex;
			this.ey = ey;
		}
	}

	static Paper[] papers;

	public static void main(String[] args) {

		initInput();

		for (Paper p : papers) {
			for (int i = p.sx; i <= p.ex; i++) {
				for (int j = p.sy; j <= p.ey; j++) {
					map[i][j]++;
				}
			}
		}
//		int cnt = goBFS();
		int cnt = 0;
		for (int i = 0; i < LEN; i++) {
			for (int j = 0; j < LEN; j++) {
				cnt += map[i][j] > M ? 1 : 0;
			}
		}
		System.out.println(cnt);

	}

	private static void initInput() {
		// N개의 불투명한 종이
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		try {
			str = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(str.nextToken());
			M = Integer.parseInt(str.nextToken());
			int sx, sy, ex, ey;
			papers = new Paper[N];
			while (N-- > 0) {
				str = new StringTokenizer(br.readLine(), " ");
				sx = Integer.parseInt(str.nextToken()) - 1;
				sy = Integer.parseInt(str.nextToken()) - 1;
				ex = Integer.parseInt(str.nextToken()) - 1;
				ey = Integer.parseInt(str.nextToken()) - 1;
				papers[N] = new Paper(sx, sy, ex, ey);
			}
		} catch (NumberFormatException | IOException e) {
		}

	}

}
