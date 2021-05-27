package silver2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class B18870_Main {

	static int N;
	static int[] arr;
	static TreeSet<Integer> ts;

	public static void main(String[] args) {

		init();
		StringBuilder sb = new StringBuilder();
		Integer[] temp = ts.toArray(new Integer[ts.size()]);
		for (int i = 0; i < N; i++) {
			int count = Arrays.binarySearch(temp, arr[i]);
			sb.append(count).append(" ");
		}

		System.out.println(sb.toString());

	}

	private static void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		try {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			ts = new TreeSet<>();
			str = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(str.nextToken());
				ts.add(arr[i]);
			}
		} catch (Exception e) {
		}
	}

}
