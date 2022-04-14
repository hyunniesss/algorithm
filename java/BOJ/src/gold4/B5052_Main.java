package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class B5052_Main {

	static int T, N;
	static String[] list;

	static BufferedReader br;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			initInput();

		}
	}

	private static void initInput() throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		list = new String[N];
		for (int i = 0; i < N; i++) {
			list[i] = br.readLine();
		}
		Arrays.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}

		});
		System.out.println(Arrays.toString(list));
	}

}
