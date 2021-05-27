package level2.기능개발;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		int[] progresses = { 93, 30, 55 };
		int[] speeds = { 1, 30, 5 };
		System.out.println(Arrays.toString(solution(progresses, speeds)));
		progresses = new int[] { 95, 90, 99, 99, 80, 99 };
		speeds = new int[] { 1, 1, 1, 1, 1, 1 };
		System.out.println(Arrays.toString(solution(progresses, speeds)));
	}

	public static int[] solution(int[] progresses, int[] speeds) {
		for (int i = 0; i < progresses.length; i++) {
			progresses[i] = (100 - progresses[i]) % speeds[i] == 0 ? (100 - progresses[i]) / speeds[i]
					: (100 - progresses[i]) / speeds[i] + 1;
		}
		List<Integer> list = new ArrayList<>();
		int max = progresses[0];
		int cnt = 0;
		for (int i = 0; i < progresses.length; i++) {
			if (max >= progresses[i]) {
				cnt++;
			} else {
				list.add(cnt);
				cnt = 1;
				max = progresses[i];
			}
		}
		list.add(cnt);
		int[] answer = new int[list.size()];
		for(int i=0;i<answer.length;i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}

}
