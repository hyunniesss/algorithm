package level1.신규아이디추천;

import java.util.StringTokenizer;

public class Solution {

	public String solution(String new_id) {
		String answer = "";
//		System.out.println(new_id);
		// 1. 소문자로 치환
		new_id = new_id.toLowerCase();
//		System.out.println("1 : " + new_id);
		// 2. 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
		StringTokenizer str = new StringTokenizer(new_id, "~!@#$%^&*()=+[{]}:?,<>/");
		while (str.hasMoreTokens()) {
			answer += str.nextToken();
		}

//		System.out.println("2 : " + answer);

		// 3. 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
		while (answer.contains("..")) {
			int idx = answer.indexOf("..", 0);
			String pref = "", next = "";
			if (idx >= 0) {
				pref = answer.substring(0, idx);
			}
			if (idx + 1 < answer.length()) {
				next = answer.substring(idx + 1);
			}
			answer = pref + next;
		}
//		System.out.println("3 : " + answer);

		// 4. 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
		while (answer.length() >= 1 && (answer.charAt(0) == '.' || answer.charAt(answer.length() - 1) == '.')) {
			if (answer.charAt(0) == '.') {
				answer = answer.substring(1);
			}
			if (answer.length() == 0) {
				break;
			}
			if (answer.charAt(answer.length() - 1) == '.') {
				answer = answer.substring(0, answer.length() - 1);
			}
		}
//		System.out.println("4 : " + answer);

		// 5. 빈 문자열이라면, new_id에 "a"를 대입합니다.
		if ("".equals(answer)) {
			answer = "a";
		}
//		System.out.println("5 : " + answer);

		// 6.new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
		// 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
		if (answer.length() >= 16) {
			answer = answer.substring(0, 15);
			if (answer.charAt(answer.length() - 1) == '.') {
				answer = answer.substring(0, answer.length() - 1);
			}
		}

//		System.out.println("6 : " + answer);
		// 7. 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
		if (answer.length() <= 2) {
			while (answer.length() < 3) {
				answer += answer.charAt(answer.length() - 1);
			}
		}
//		System.out.println("7 : " + answer);

		return answer;
	}

}
