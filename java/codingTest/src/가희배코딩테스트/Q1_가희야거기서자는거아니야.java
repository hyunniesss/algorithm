package 가희배코딩테스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q1_가희야거기서자는거아니야 {

	static int R, C;
	static int pillow, gahi;
	static char[][] MAP;
	static boolean[][] check;
	static boolean flag;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(str.nextToken());
		C = Integer.parseInt(str.nextToken());
		MAP = new char[R][C];
		check = new boolean[R][C];
		str = new StringTokenizer(br.readLine(), " ");
		gahi = Integer.parseInt(str.nextToken()) * Integer.parseInt(str.nextToken());
		pillow = Integer.parseInt(str.nextToken()) * Integer.parseInt(str.nextToken());

		for (int r = 0; r < R; r++) {
			MAP[r] = br.readLine().toCharArray();
		}
		ArrayList<Integer> g = new ArrayList<>();
		ArrayList<Integer> p = new ArrayList<>();
		int psum = 0;
		int gsum = 0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (MAP[r][c] == 'G' && !check[r][c]) {
					sum = 0;
					check[r][c] = true;
					dfs(r, c);
					g.add(sum);
					gsum += sum;
				} else if (MAP[r][c] == 'P' && !check[r][c]) {
					sum = 0;
					check[r][c] = true;
					dfs(r, c);
					p.add(sum);
					psum += sum;
				}
			}
		}
		if (g.size() == 1 && psum < pillow && gsum == gahi) { // 가희가 하나이고 베게가 충분히 채워지지 않았으면
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int sum;

	private static void dfs(int r, int c) {
		sum++;
		for (int d = 0; d < dirs.length; d++) {
			int nr = r + dirs[d][0];
			int nc = c + dirs[d][1];
			if (canGo(nr, nc, r, c)) {
				check[nr][nc] = true;
				dfs(nr, nc);
			}
		}

	}

	private static boolean canGo(int r, int c, int pr, int pc) {
		return r >= 0 && r < R && c >= 0 && c < C && MAP[r][c] == MAP[pr][pc] && !check[r][c];
	}

}
