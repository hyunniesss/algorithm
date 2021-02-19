package gold1.B20304;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");

		char[][] password = new char[M][21];
		for (int m = 0; m < M; m++) {
			Arrays.fill(password[m], '0');
		}
		for (int m = 0; m < M; m++) {
			StringBuilder temp = new StringBuilder(Integer.toBinaryString(Integer.parseInt(str.nextToken())));
			temp = temp.reverse();
			for (int i = 0; i < temp.length(); i++) {
				password[m][i] = temp.charAt(i);
			}
		} // end input

		int answer = -1;
		char[] number = new char[21];
		Arrays.fill(number, '0');
		for (int i = 0; i <= N; i++) {
			StringBuilder temp = new StringBuilder(Integer.toBinaryString(i));
			temp = temp.reverse();
			for (int j = 0; j < temp.length(); j++) {
				number[j] = temp.charAt(j);
			}

			for (int k = 0; k < 21; k++) { // 자릿수
				int count = 0;
				for (int j = 0; j < M; j++) {
					if (number[k] != password[j][k]) {
						count++;
					}
				}
				if (count == M) {
					answer++;
				}
			}
		}

		System.out.println(answer);

	}

}
