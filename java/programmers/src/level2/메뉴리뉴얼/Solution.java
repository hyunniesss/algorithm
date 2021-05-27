package level2.메뉴리뉴얼;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

	Map<String, Integer> map = new HashMap<>();
	ArrayList<String> list = new ArrayList<>();

	public String[] solution(String[] orders, int[] course) {

		for (int i = 0; i < orders.length; i++) {
			for (int r = 2; r <= orders[i].length(); r++) {
				combination(orders[i].toCharArray(), "", 0, r, 0);
			}
		}

		for (int j = 0; j < list.size(); j++) {
			int len = list.get(j).length();
			boolean flag = false;
			for (int i = 0; i < course.length; i++) {
				if (len == course[i]) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				list.remove(j);
				j--;
			}
		}
		String[] answer = new String[list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}

		Arrays.sort(answer);
		return answer;
	}

	private void combination(char[] input, String res, int cur, int R, int cnt) {
		if (cnt == R) {
			char[] temp = res.toCharArray();
			Arrays.sort(temp);
			res = "";
			for (char c : temp) {
				res += c;
			}
			if (map.containsKey(res) && !list.contains(res)) {
				list.add(res);
				map.remove(res);
			} else {
				map.put(res, 1);
			}
			System.out.println(Arrays.toString(input) + " " + res);
		}

		for (int i = cur; i < input.length; i++) {
			if (res.contains(input[i] + "")) {
				continue;
			}
			combination(input, res + input[i], i + 1, R, cnt + 1);
		}

	}

}
