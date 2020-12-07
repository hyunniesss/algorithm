package silver3.B1966;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int TC;
	static StringBuilder sb = new StringBuilder();
	static List<int[]> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		while (TC-- > 0) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(str.nextToken());
			int M = Integer.parseInt(str.nextToken()); // 목표위치

			str = new StringTokenizer(br.readLine());
			int index = 0;
			while (str.hasMoreTokens()) {
				int[] cur = new int[] { index, Integer.parseInt(str.nextToken()) };
				index++;
				list.add(cur);
			}
			int answer = 0;
			boolean flag = true;
			do {
				int[] cur = list.get(0);
				flag = true;
				for (int i = 1; i < list.size(); i++) {
					if (list.get(i)[1] > cur[1]) {
						list.remove(0);
						list.add(cur);
						flag = false;
						break;
					}
					if(flag) {
						int[] r = list.remove(0);
						if(r[0] == M) {
							answer++;
							flag = true;
							break;
						} else {
							flag = false;
							answer++;
						}
					}
				}
			} while (!flag);
			
			sb.append(answer).append("\n");
		}
		System.out.println(sb);

	}

}
