package level2.가장큰수;

public class Solution {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 6, 10, 2 }));
		System.out.println(solution(new int[] { 3, 30, 34, 5, 9 }));
	}

	public static String solution(int[] numbers) {
		String answer = "";
		answer = permutation(0, numbers, new boolean[numbers.length], "", answer);
		return answer;
	}

	private static String permutation(int cnt, int[] numbers, boolean[] check, String temp, String answer) {
		if (cnt == numbers.length) {
			char[] tempToArr = temp.toCharArray();
			if (answer.length() != temp.length()) {
				answer = temp;
			} else {
				char[] answerToArr = answer.toCharArray();
				for (int i = 0; i < tempToArr.length; i++) {
					if (tempToArr[i] == answerToArr[i]) {
						continue;
					} else if (tempToArr[i] > answerToArr[i]) {
						answer = temp;
						break;
					} else {
						break;
					}
				}
			}
			return answer;
		}
		for (int i = 0; i < numbers.length; i++) {
			if (!check[i]) {
				check[i] = true;
				answer = permutation(cnt + 1, numbers, check, temp + numbers[i], answer);
				check[i] = false;
			}
		}
		return answer;
	}

}
