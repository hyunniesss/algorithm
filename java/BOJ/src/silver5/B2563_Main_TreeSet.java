package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class B2563_Main_TreeSet {

	static TreeSet<Integer>[] list = new TreeSet[101];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 색종이 수
		for (int i = 0; i < list.length; i++) {
			list[i] = new TreeSet<>();
		}
		for (int n = 0; n < N; n++) {
			StringTokenizer str = new StringTokenizer(br.readLine(), " ");
			int R = Integer.parseInt(str.nextToken());
			int C = Integer.parseInt(str.nextToken());
			for (int r = R; r < R + 10; r++) {
				for (int c = C; c < C + 10; c++) {
					list[r].add(c);
				}
			}
		}
		int sum = 0;
		for (int i = 0; i < 101; i++) {
			sum += list[i].size();
		}
		System.out.println(sum);
	}

}
