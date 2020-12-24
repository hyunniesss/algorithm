package level2.프린터;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		int[] priorities = { 1,2,3,1,3,1,4, 9, 1,3,4,2,2 };
		int location = 0;
		System.out.println(solution(priorities, location));
//		priorities = new int[] { 1, 1, 9, 1, 1, 1 };
//		location = 0;
//		System.out.println(solution(priorities, location));
//		priorities = new int[] { 2,2,2,2 };
//		location = 2;
//		System.out.println(solution(priorities, location));
	}

	public static int solution(int[] priorities, int location) {
		int answer = 0;
		List<int[]> papers = new ArrayList<>();
		for (int i = 0; i < priorities.length; i++) {
			papers.add(new int[] { i, priorities[i] });
		}
		while (!papers.isEmpty()) {
			int[] cur = papers.get(0);
			boolean flag = true;
			for (int i = 1; i < papers.size(); i++) {
				int[] temp = papers.get(i);
				if (temp[1] > cur[1]) {
					papers.remove(0);
					papers.add(cur);
					flag = false;
					break;
				}
			}
			if (flag) {
				answer++;
				papers.remove(0);
				if (cur[0] == location) {
					return answer;
				}
			}
		}
		return answer;
	}

}
