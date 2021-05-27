package level2.예상대진표;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	public int solution(int n, int a, int b) {
		int answer = 3;

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			queue.offer(i);
		}
		int round = 1;
		while (queue.size() > 1) {
			Queue<Integer> temp = new LinkedList<>();
			while (queue.size() > 1) {
				int tempA = queue.poll();
				if (queue.isEmpty()) {
					temp.offer(tempA);
					break;
				}
				int tempB = queue.poll();
				if ((tempA == a && tempB == b) || (tempA == b && tempB == a)) {
					return round;
				}
				if (tempA == a || tempA == b) {
					temp.offer(tempA);
				} else if (tempB == a || tempB == b) {
					temp.offer(tempB);
				} else {
					temp.offer(tempA);
				}
			}
			round++;
			queue = temp;

		}

		return answer;
	}

}
