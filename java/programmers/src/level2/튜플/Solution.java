package level2.튜플;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

	public int[] solution(String s) {

		StringTokenizer str = new StringTokenizer(s, "}");
		StringTokenizer st = null;
		ArrayList<Integer>[] al = new ArrayList[str.countTokens()];
		for (int i = 0; i < al.length; i++) {
			al[i] = new ArrayList<>();
		}
		int idx = 0;
		while (str.hasMoreTokens()) {
			st = new StringTokenizer(str.nextToken(), "{,");
			while (st.hasMoreTokens()) {
				al[idx].add(Integer.parseInt(st.nextToken()));
			}
			idx++;
		}

		Arrays.sort(al, new Comparator<ArrayList<Integer>>() {
			@Override
			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
				return Integer.compare(o1.size(), o2.size());
			}
		});

		int[] answer = new int[al.length];
		HashSet<Integer> set = new HashSet<>();

		for (int i = 0; i < al.length; i++) {
			for (int j = 0; j < al[i].size(); j++) {
				int next = al[i].get(j);
				if (set.contains(next)) {
					continue;
				}
				answer[i] = next;
				set.add(next);
				break;
			}
		}

		return answer;
	}

}
