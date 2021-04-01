package level2;

public class 타겟넘버_Solution {

	public int solution(int[] numbers, int target) {
		int answer = 0;
		return dfs(numbers, target, answer, 0);
	}

	private int dfs(int[] numbers, int target, int answer, int cur) {
		if (cur == numbers.length) {
			if (target == 0) {
				return answer + 1;
			}
			return answer;
		}

		return dfs(numbers, target - numbers[cur], answer, cur + 1)
				+ dfs(numbers, target + numbers[cur], answer, cur + 1);
	}

}
