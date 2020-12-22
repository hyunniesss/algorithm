package level1.예산;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		int[] d = { 1, 3, 2, 5, 4 };
		int budget = 9;
		System.out.println(solution(d, budget));
		d = new int[] { 2, 2, 3, 3 };
		budget = 10;
		System.out.println(solution(d, budget));
	}

	public static int solution(int[] d, int budget) {
		int answer = 0;
		Arrays.sort(d);
		int idx = 0;
		while (budget > 0 && idx < d.length) {
			budget -= d[idx++];
			answer++;
		}
		answer = budget >= 0 ? answer : answer - 1;
		return answer;
	}

}
