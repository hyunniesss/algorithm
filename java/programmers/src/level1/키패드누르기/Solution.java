package level1.키패드누르기;

public class Solution {

	final String keyPad = "123456789*0#";

	public String solution(int[] numbers, String hand) {
		StringBuilder answer = new StringBuilder();

		int left = 9;
		int right = 11;

		for (int i : numbers) {
			if (i > 0 && i % 3 == 0) { // 3, 6, 9
				answer.append("R");
				right = i - 1;
			} else if (i % 3 == 1) { // 1, 4, 7
				answer.append("L");
				left = i - 1;
			} else { // 2, 4, 6, 8, 0
				int temp = keyPad.indexOf(i + "");
//				거리 비교해야해
				int tempA = Math.abs(left / 3 - temp / 3) + Math.abs(left % 3 - temp % 3);
				int tempB = Math.abs(right / 3 - temp / 3) + Math.abs(right % 3 - temp % 3);
				if (tempA == tempB) {
					if ("left".equals(hand)) {
						answer.append("L");
						left = temp;
					} else {
						answer.append("R");
						right = temp;
					}
				} else if (tempA < tempB) {
					answer.append("L");
					left = temp;
				} else {
					answer.append("R");
					right = temp;
				}

			}
		}

		return answer.toString();
	}

}
