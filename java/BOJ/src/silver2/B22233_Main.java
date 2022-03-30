package silver2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class B22233_Main {

	static int N, M;
	static Set<String> memo;

	public static void main(String[] args) {
		String[] blog = initInput();
		getKeyword(blog);
	}

	private static void getKeyword(String[] blog) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			StringTokenizer str = new StringTokenizer(blog[i], ",");
			while (str.hasMoreTokens()) {
				memo.remove(str.nextToken());
			}
			sb.append(memo.size()).append("\n");
		}
		printAnswer(sb.toString());
	}

	private static void printAnswer(String s) {
		System.out.println(s);
	}

	private static String[] initInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		String[] blog = null;
		try {
			str = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(str.nextToken());
			M = Integer.parseInt(str.nextToken());
			blog = new String[M];
			memo = new HashSet<String>();
			for (int i = 0; i < N; i++) {
				memo.add(br.readLine());
			}
			for (int i = 0; i < M; i++) {
				blog[i] = br.readLine();
			}
		} catch (Exception e) {
		}
		return blog;
	}
}
