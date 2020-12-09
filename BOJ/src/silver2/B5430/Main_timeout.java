package silver2.B5430;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main_timeout {

	static int T, N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			LinkedList<Integer> list = new LinkedList<>();
			ListIterator<Integer> iter = list.listIterator(list.size());
			char[] punc = br.readLine().toCharArray();
			N = Integer.parseInt(br.readLine());
			StringTokenizer str = new StringTokenizer(br.readLine(), "[],");
			while (str.hasMoreTokens()) {
				iter.add(Integer.parseInt(str.nextToken()));
			}
			while (iter.hasPrevious()) {
				iter.previous();
			}
			boolean flag = true;
			for (int i = 0; i < punc.length; i++) {
				switch (punc[i]) {
				case 'R':
					if (iter.hasPrevious()) {
						while (iter.hasPrevious()) {
							iter.previous();
						}
					} else {
						while (iter.hasNext()) {
							iter.next();
						}
					}
					break;
				case 'D':
					if (iter.hasNext() || iter.hasPrevious()) {
						if (iter.hasNext()) {
							iter.next();
							iter.remove();
						} else {
							iter.previous();
							iter.remove();
						}
					} else {
						sb.append("error\n");
						flag = false;
					}
					break;
				}
				if(!flag)
					break;
			}

			if (list.size() > 0) {
				sb.append("[");
				if (iter.hasNext()) {
					for (int i : list) {
						sb.append(i + ",");
					}
				} else {
					for (int i = list.size() - 1; i >= 0; i--) {
						sb.append(list.get(i) + ",");
					}
				}
				sb = new StringBuilder(sb.substring(0, sb.length() - 1));
				sb.append("]\n");
			}
		}

		System.out.println(sb);

	}

}
