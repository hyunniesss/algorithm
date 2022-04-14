package bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10708_Main {

	static class Input {
		int N; // 사람 수
		int M; // 게임수
		int[] targets; // 타겟
		int[][] games; // 예상타겟

		public Input(int n, int m, int[] targets, int[][] games) {
			N = n;
			M = m;
			this.targets = targets;
			this.games = games;
		}
	}

	public static void main(String[] args) {
		Input inputs = initInput();
		int[] answer = new int[inputs.N];
		for(int i=0;i<inputs.M;i++) {	// M번의 게임 중에			
			int bonus=0;
			for(int j=0;j<inputs.N;j++) {	// N명의 친구가
				if(inputs.targets[i] == inputs.games[i][j]) {
					answer[j]++;
				} else {
					bonus++;
				}
			}
			answer[inputs.targets[i]]+=bonus;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<answer.length;i++) {
			sb.append(answer[i]).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static Input initInput() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		Input in = null;
		try {
			int n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());
			int[] targets = new int[m];
			str = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < m; i++) {
				targets[i] = Integer.parseInt(str.nextToken()) - 1;
			}
			int[][] games = new int[m][n];
			for (int i = 0; i < m; i++) {
				str = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					games[i][j] = Integer.parseInt(str.nextToken()) - 1;
				}
			}
			in = new Input(n, m, targets, games);
		} catch (NumberFormatException | IOException e) {
		}

		return in;
	}

}
