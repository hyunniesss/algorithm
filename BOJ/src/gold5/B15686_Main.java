package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B15686_Main {

	static int N, M, result;
	static List<int[]> homes = new ArrayList<int[]>();
	static List<int[]> chicken = new ArrayList<int[]>();
	static int chickenCount, homeCount;
	static final int MAX = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		result = MAX;

		for (int r = 0; r < N; r++) {
			str = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < N; c++) {
				switch (Integer.parseInt(str.nextToken())) {
				case 1: // 집이면 home리스트에 추가
					homes.add(new int[] { r, c });
					break;
				case 2: // 치킨집이면 chicken리스트에 추가
					chicken.add(new int[] { r, c });
				}
			}
		} // end input

		int flag = 0, count = 0;
		// 치킨집이랑 집 갯수는 변하지 않으니 한 번만 처리하도록 static으로 선언
		chickenCount = chicken.size();
		homeCount = homes.size();

		combi(flag, count, 0);

		System.out.println(result);

	}

	private static void combi(int flag, int count, int cur) {
		if (count == M) {
			int sum = 0;
			for (int i = 0; i < homeCount; i++) {
				sum += findMin(flag, homes.get(i));
				if (sum >= result) {
					return;
				}
			}
			result = sum;
			return;
		}

		for (int i = cur; i < chickenCount; i++) {
			if ((flag & 1 << i) == 0) {
				combi(flag | 1 << i, count + 1, i + 1);
			}
		}

	}

	private static int findMin(int flag, int[] home) {
		int min = MAX;
		for (int j = 0; j < chickenCount; j++) {
			if ((flag & (1 << j)) != 0) {
				int[] chi = chicken.get(j);
				min = Math.min(min, Math.abs(home[0] - chi[0]) + Math.abs(home[1] - chi[1]));
			}
		}
		return min;
	}

}
