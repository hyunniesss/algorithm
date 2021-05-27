package level2.n진수게임;

public class Solution {

	public static void main(String[] args) {

		System.out.println("ANSWER : " + solution(2, 4, 2, 1));
		System.out.println("ANSWER : " + solution(16, 16, 2, 1));
		System.out.println("ANSWER : " + solution(16, 16, 2, 2));

	}

	public static String solution(int n, int t, int m, int p) {
		String answer = "";
		String numbers = "-";
		int len = m * (t + 1);
		int index = 0;
		while (numbers.length() < len) {
			numbers += Integer.toString(index, n).toUpperCase();
			index++;
		}
		for (int i = 0; i < t; i++) {
			answer += numbers.charAt(i * m + p);
		}
		return answer;
	}

}
