package level1.신고결과받기;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Solution {
	public int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];
		ArrayList<ArrayList<String>> reporteeList = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		StringTokenizer str = null;
		for (int i = 0; i < id_list.length; i++) {
			reporteeList.add(new ArrayList<>());
			map.put(id_list[i], i);
		}

		for (String s : report) {
			str = new StringTokenizer(s, " ");
			String a = str.nextToken();
			String b = str.nextToken();
			if (reporteeList.get(map.get(b)).contains(a)) {
				continue;
			}
			reporteeList.get(map.get(b)).add(a);
		}
		for (int i = 0; i < reporteeList.size(); i++) {
			ArrayList<String> list = reporteeList.get(i);
			if (list.size() >= k) {
				for (String ss : list) {
					answer[map.get(ss)]++;
				}
			}
		}
		return answer;
	}
}