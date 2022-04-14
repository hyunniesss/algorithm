package level2.문자열압축;

public class Solution {

	public int solution(String s) {
		int answer = s.length();
		out: for (int i = 1; i <= s.length() / 2; i++) { // 쪼갤 단어 갯수
			String all = "";
			String pref = s.substring(0, i);
			int count = 1;
			int j = i;
			for (; j <= s.length() - i; j += i) {
				String cur = s.substring(j, j + i);
				if (pref.equals(cur)) {
					count++;
				} else {
					all += count == 1 ? pref : (count + pref);
					pref = cur;
					count = 1;
				}
				
				if (all.length() > answer) {
					continue out;
				}
			}
			all += count == 1 ? pref : count + pref;
			all += s.substring(j);
			

			answer = Math.min(answer, all.length());
		}

		return answer;
	}

}
