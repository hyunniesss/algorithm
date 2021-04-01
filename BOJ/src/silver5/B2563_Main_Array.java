package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2563_Main_Array {

	static boolean[][] map = new boolean[100][100];
	static final int SIZE = 100, COLORED = 10;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 색종이 수

		while (N-- > 0) {
			StringTokenizer str = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(str.nextToken());
			int c = Integer.parseInt(str.nextToken());

			for (int i = 0; i < COLORED; i++) {
				for (int j = 0; j < COLORED; j++) {
					map[r + i][c + j] = true;
				}
			}
		}
		int answer = 0;
		for(int i=0;i<SIZE;i++) {
			for(int j=0;j<SIZE;j++) {
				if(map[i][j]) {
					answer++;
				}
			}
		}
		
		System.out.println(answer);
	}

}
