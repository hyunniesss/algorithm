package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11123_Main {

	static class Input {
		int R, C;
		char[][] map;
		boolean[][] check;

		public Input(int r, int c, char[][] map, boolean[][] check) {
			R = r;
			C = c;
			this.map = map;
			this.check = check;
		}

		public boolean canGo(int r, int c) {
			return r >= 0 && r < R && c >= 0 && c < C && map[r][c] == '#' && !check[r][c];
		}

	}

	static Input[] inputs;

	public static void main(String[] args) {

		initInput();
		StringBuilder sb = new StringBuilder();

		for (Input inp : inputs) {
			sb.append(countSheep(inp)).append("\n");
		}
		
		System.out.println(sb.toString());

	}

	private static int countSheep(Input inp) {
		int count = 0;
		for (int r = 0; r < inp.R; r++) {
			for (int c = 0; c < inp.C; c++) {
				if (inp.canGo(r,c)) {
					dfs(inp, r, c);
					count++;
				}
			}
		}
		return count;
	}

	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	private static void dfs(Input inp, int r, int c) {
		if (!inp.canGo(r, c)) {
			return;
		}
		inp.check[r][c] = true;
		int nr, nc;
		for (int d = 0; d < dirs.length; d++) {
			nr = r + dirs[d][0];
			nc = c + dirs[d][1];
			dfs(inp, nr, nc);
		}

	}

	private static void initInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		try {
			int T = Integer.parseInt(br.readLine());
			inputs = new Input[T];
			for(int t=0;t<T;t++) {
				str = new StringTokenizer(br.readLine()," ");
				int R = Integer.parseInt(str.nextToken());
				int C = Integer.parseInt(str.nextToken());
				char[][] map = new char[R][C];
				boolean[][] check = new boolean[R][C];
				for(int r = 0;r<R;r++) {
					map[r] = br.readLine().toCharArray();
				}
				inputs[t] = new Input(R, C, map, check);
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

}
