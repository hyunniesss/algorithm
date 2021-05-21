package bronze1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B4344_Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int C = Integer.parseInt(br.readLine());
		ArrayList<Integer> jumsu;
		for (int c = 0; c < C; c++) {
			StringTokenizer str = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(str.nextToken());
			jumsu = new ArrayList<>();
			float avg = 0.0f;
			for (int n = 0; n < N; n++) {
				int temp = Integer.parseInt(str.nextToken());
				jumsu.add(temp);
				avg += temp;
			}
			avg /= (float) N;
			Collections.sort(jumsu);
			int idx = 0;
			while (idx < jumsu.size() && avg >= jumsu.get(idx++))
				;
			float percentage = 100 - (((idx - 1) / (float) N) * 100);

			System.out.printf("%.03f", percentage);
			System.out.println("%");
		}
	}

}
