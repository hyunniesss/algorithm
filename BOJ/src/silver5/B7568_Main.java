package silver5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B7568_Main {

	static int N;
	static int[] rank;
	static int[][] people;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine()); // 사람 수
		rank = new int[N];
		people = new int[N][3]; // index, weight, height

		for (int n = 0; n < N; n++) {
			StringTokenizer str = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i < 3; i++) {
				people[n][i] = Integer.parseInt(str.nextToken());
			}
		}

		for (int i = 0; i < N; i++) { // 나
			for (int j = 0; j < N; j++) { // 비교대상
				if (people[i][1] < people[j][1] && people[i][2] < people[j][2]) {
					people[i][0]++;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			bw.write((people[i][0] + 1) + " ");
		}

		bw.newLine();
		bw.flush();

	}

}
