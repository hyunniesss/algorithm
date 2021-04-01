package bronze2;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class B2562_Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 1.
//		int[] number = new int[9];
//		int maxIdx = 0;
//
//		for (int i = 0; i < 9; i++) {
//
//			number[i] = Integer.parseInt(br.readLine());
//			maxIdx = number[i] > number[maxIdx] ? i : maxIdx;
//
//		}
//		bw.write(number[maxIdx] + "\n");
//		bw.write((maxIdx + 1) + "");
//		bw.flush();

		// 2.
		int[][] number = new int[9][2];
		for (int i = 0; i < 9; i++) {
			number[i][0] = Integer.parseInt(br.readLine());
			number[i][1] = i + 1;
		}

		Arrays.sort(number, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}

		});

		bw.write(number[8][0] + "\n" + number[8][1]);
		bw.flush();

	}

}
