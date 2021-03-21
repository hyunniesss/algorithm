package line202103;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Q12 {

	List<String> command = new ArrayList<>();

	public boolean[] solution(String program, String[] flag_rules, String[] commands) {

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
			command.clear();

			str = new StringTokenizer(commands[i], " ");

			while (str.hasMoreTokens()) {
				command.add(str.nextToken());
			}
			// 1. program 명이 다르면 체킹 끝
			answer[i] = test1(command.remove(0), program);

			// 2. command 확인
			if (answer[i]) {
				while (answer[i] && command.size() > 0) {
					String ruleType = flagRules.getOrDefault(command.remove(0), null);
					if (ruleType == null) { // flagrule에 일치하는 커멘드가 없다면 잘못된 command
						answer[i] = false;
						break;
					} else {
						if ("NULL".equals(ruleType)) { // ruleType이 널이면 다음 단어를 보지않아도 된다.
							continue;
						} else if (command.size() == 0) { // 커맨드 남은 길이가 0이면 필요한 정보를 입력받을 수 없으니
							answer[i] = false;
							break;
						} else { // 위 두 조건에 걸리지 않는다면 체크해볼만한 커멘드
							answer[i] = test2(ruleType);
						}
					}
				}
			}
		}

		return answer;
	}

	private boolean test1(String input, String program) {
		return program.equals(input);
	}

	private boolean test2(String ruleType) {
		boolean answer = false;
		List<String> input = new ArrayList<>();

		switch (ruleType) {
		case "STRING":
			answer = stringTest(new String[] { command.remove(0) });
			break;
		case "NUMBER":
			answer = numberTest(new String[] { command.remove(0) });
			break;
		case "STRINGS":
			input = new ArrayList<>();
			while (command.size() > 0 && command.get(0).charAt(0) != '-') {
				input.add(command.remove(0));
			}
			answer = stringTest(input.toArray());
			break;
		case "NUMBERS":
			input = new ArrayList<>();
			while (command.size() > 0 && command.get(0).charAt(0) != '-') {
				input.add(command.remove(0));
			}
			answer = numberTest(input.toArray());
			break;
		}
		return answer;
	}

	private boolean numberTest(Object[] input) {
		for (int i = 0; i < input.length; i++) {
			try {
				int num = Integer.parseInt((String) input[i]); // integer로 형변환했을 때 에러처리를 통해 숫자형인지 확인한다
			} catch (NumberFormatException e) {
				return false;
			}
		}
		return true;
	}

	private boolean stringTest(Object[] input) {
		for (int j = 0; j < input.length; j++) {
			String word = (String) input[j];
			for (int i = 0; i < word.length(); i++) {
				char temp = word.charAt(i);
				if ((temp >= 'A' && temp <= 'Z') || (temp >= 'a' && temp <= 'z')) { // 영어 대소문자 이면 다음 문자도 확인
					continue;
				} else { // 영어 대소문자가 아니라면 잘못된 표현
					return false;
				}
			}
		}
		return true;
	}

}
