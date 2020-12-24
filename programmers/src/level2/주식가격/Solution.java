package level2.주식가격;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	public static void main(String[] args) {

		System.out.println(Arrays.toString(solution(new int[] { 1, 2, 3, 2, 3 })));

	}

	static class Point {
		int price;
		int start;
		int index;

		public Point(int price, int start, int index) {
			this.price = price;
			this.start = start;
			this.index = index;
		}

	}

	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];

		Queue<Point> queue = new LinkedList<>();
		int time = 0;
		for (int i = 0; i < prices.length; i++) {
			queue.offer(new Point(prices[i], i, i + 1));
		}

		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			if (cur.index >= prices.length) {
				answer[cur.start] = cur.index - cur.start - 1;
			} else if (cur.price > prices[cur.index]) {
				answer[cur.start] = cur.index - cur.start;
			} else {
				queue.offer(new Point(cur.price, cur.start, cur.index + 1));
			}
		}

		return answer;
	}

}
