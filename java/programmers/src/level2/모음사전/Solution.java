package level2.모음사전;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		System.out.println(solution(new Scanner(System.in).nextLine()));
	}

	public static int solution(String word) {
		int answer = 0;
		String s = "";
		do {
			s = nP(s);
			answer++;
		} while (!word.equals(s));

		return answer;
	}

	private static String nP(String s) {
		char[] sArr = s.toCharArray();
		if (sArr.length == 5) {
			int x = sArr.length - 1;
			while (sArr[x] == 'U') {
				x--;
			}
			s = s.substring(0, x);
			switch (sArr[x]) {
			case 'A':
				s += 'E';
				break;
			case 'E':
				s += 'I';
				break;
			case 'I':
				s += 'O';
				break;
			case 'O':
				s += 'U';
				break;
			}
		} else {
			s += 'A';
		}
		return s;
	}
}
