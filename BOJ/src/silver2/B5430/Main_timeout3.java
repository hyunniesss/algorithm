package silver2.B5430;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_timeout3 {

	static int T;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		out: while (T-- > 0) {
			char[] punc = br.readLine().toCharArray();
			br.readLine();
			String arr = br.readLine().trim();
			boolean flag = true; // 이게 앞
			for (char p : punc) {
				switch (p) {
				case 'R':
					flag = !flag;
					break;
				case 'D':
					if ("[]".equals(arr)) {
						System.out.println("error");
						continue out;
					}
					if (flag) { // 앞의 단어 제거
						int idx = arr.indexOf(',', 0);
						if (idx == -1) {
							arr = "[]";
						} else {
							arr = arr.substring(0, 1) + arr.substring(idx+1);
						}
					} else {
						int idx = arr.length() - 2;
						while (arr.charAt(idx) != ',')
							idx--;
						arr = arr.substring(0, idx) + "]";
					}
					break;
				}
			}
			if (!"[]".equals(arr)) {
				if (!flag) {
					StringTokenizer str = new StringTokenizer(arr, "[,]");
					int[] temp = new int[str.countTokens()];
					int idx = temp.length - 1;
					while (str.hasMoreTokens()) {
						temp[idx--] = Integer.parseInt(str.nextToken());
					}
					System.out.println(Arrays.toString(temp).replaceAll(" ", ""));
				} else {
					System.out.println(arr);
				}
			} else {
				System.out.println("error");
			}
		}

	}

}
