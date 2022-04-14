package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B22232_Main {

	static int N, M;
	static Map<String, Integer> EXTENSION;

	public static void main(String[] args) {
		String[] filename = initInput();
		sortFile(filename);
		printFile(filename);
	}

	private static void printFile(String[] filename) {
		StringBuilder sb = new StringBuilder();
		for (String s : filename) {
			sb.append(s).append("\n");
		}
		System.out.println(sb.toString());

	}

	private static void sortFile(String[] filename) {

		Arrays.sort(filename, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				StringTokenizer st1 = new StringTokenizer(o1, ".");
				StringTokenizer st2 = new StringTokenizer(o2, ".");
				String filename1 = st1.nextToken();
				String filename2 = st2.nextToken();
				String ext1 = st1.nextToken();
				String ext2 = st2.nextToken();
				if (filename1.equals(filename2)) { // 2. 같으면
					int idx1 = getExtension(ext1);
					int idx2 = getExtension(ext2);
					if (idx1 == idx2) {
						return ext1.compareTo(ext2);
					}
					return Integer.compare(idx1, idx2); // 2-3. 확장자명 사전순
				}
				return filename1.compareTo(filename2); // 1. 파일명 사전순
			}

			private int getExtension(String o) {
				return EXTENSION.getOrDefault(o, M);
			}
		});
	}

	private static String[] initInput() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		String[] input = null;
		EXTENSION = new HashMap<>();
		try {
			str = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(str.nextToken());
			M = Integer.parseInt(str.nextToken());
			input = new String[N];
			for (int i = 0; i < N; i++) {
				input[i] = br.readLine();
			}
			String[] exts = new String[M];
			for (int i = 0; i < M; i++) {
				exts[i] = br.readLine();
			}
			Arrays.sort(exts);
			for (int i = 0; i < M; i++) {
				EXTENSION.put(exts[i], i);
			}
		} catch (IOException e) {
		}

		return input;
	}

}
