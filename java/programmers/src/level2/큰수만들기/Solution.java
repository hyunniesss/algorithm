package level2.큰수만들기;

class Solution {

	public String solution(String number, int k) {
		String answer = "";

		int count = 0;
		for (int i = 0; i < number.length(); i++) {

			if ("".equals(answer)) {
				answer += number.charAt(i);
			} else {
				while (answer.length() > 0 && count < k && answer.charAt(answer.length() - 1) < number.charAt(i)) {
					answer = answer.substring(0, answer.length() - 1);
					count++;
				}
				if (count == k) {
					answer += number.substring(i);
					break;
				} else {
					answer += number.charAt(i);
				}
			}

		}

		if (count < k) {
			answer = answer.substring(0, answer.length() - (k - count));
		}

		return answer;
	}

}