package line202103;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q11 {

	public static void main(String[] args) {

		solution("line", new String[] { "-s STRING", "-n NUMBER", "-e NULL" },
				new String[] { "line -n 100 -s hi -e", "lien -s Bye" });

	}

	public static boolean[] solution(String program, String[] flag_rules, String[] commands) {

		boolean[] answer = new boolean[commands.length];
		Arrays.fill(answer, true);// 우선 다 조건에 맞게 입력했다고 가정하고 시작해서 가정에 어긋나면 false로 교체

		Map<String, String> flagRules = new HashMap<>(); // flag_rules를 확인하기 쉽게 하기 위해 맵에 저장
		StringTokenizer str = null;

		for (int i = 0; i < flag_rules.length; i++) {
			str = new StringTokenizer(flag_rules[i], " ");
			String rule = str.nextToken();
			String type = str.nextToken();
			flagRules.put(rule, type);
		}

		for (int i = 0; i < commands.length; i++) {

			str = new StringTokenizer(commands[i], " ");
			// 1. program 명이 다르면 체킹 끝
			answer[i] = test1(str.nextToken(), program);
			// 2. command 확인
			if (answer[i]) {
				while (str.hasMoreTokens()) {
					String command = str.nextToken();
					String ruleType = flagRules.getOrDefault(command, null);
					if (ruleType == null) { // flagrule에 일치하는 커멘드가 없다면 잘못된 command
						answer[i] = false;
						break;
					} else {
						if ("NULL".equals(ruleType)) { // ruleType이 널이면 다음 단어를 보지않아도 된다.
							continue;
						} else if (str.countTokens() == 0) { // NULL이 아닌데 다음에 단어가 없으면 그것도 잘못된 커멘드
							answer[i] = false;
							break;
						} else { // 위 두 조건에 걸리지 않는다면 체크해볼만한 커멘드
							answer[i] = test2(str.nextToken(), ruleType);
						}
					}
				}
			}
		}

		return answer;
	}

	private static boolean test1(String input, String program) {
		return program.equals(input);
	}

	private static boolean test2(String input, String ruleType) {
		boolean answer = false;
		switch (ruleType) {
		case "STRING":
			answer = stringTest(input);
			break;
		case "NUMBER":
			answer = numberTest(input);
			break;
		}
		return answer;
	}

	private static boolean numberTest(String input) {
		try {
			int num = Integer.parseInt(input); // integer로 형변환했을 때 에러처리를 통해 숫자형인지 확인한다
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	private static boolean stringTest(String input) {
		for (int i = 0; i < input.length(); i++) {
			char temp = input.charAt(i);
			if ((temp >= 'A' && temp <= 'Z') || (temp >= 'a' && temp <= 'z')) { // 영어 대소문자 이면 다음 문자도 확인
				continue;
			} else { // 영어 대소문자가 아니라면 잘못된 표현
				return false;
			}
		}
		return true;
	}

}
