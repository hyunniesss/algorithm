package line202103;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q1 {

	public static void main(String[] args) {

		String[] table = { "SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
				"HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
				"GAME C++ C# JAVASCRIPT C JAVA" };
		String[] languages = { "JAVA", "JAVASCRIPT" };
		int[] preferences = { 7, 5 };

		System.out.println(solution(table, languages, preferences));

	}

	public static String solution(String[] table, String[] languages, int[] preference) {

		Map<String, Integer> map = new HashMap<>(); // 이건 언어 선호도

		for (int i = 0; i < languages.length; i++) {
			map.put(languages[i], preference[i]);
		}

		Map<String, Integer> langScore;

		int maxScore = -1;
		String maxJob = "";

		for (int i = 0; i < table.length; i++) {
			langScore = new HashMap<>();
			int count = 5;
			StringTokenizer str = new StringTokenizer(table[i], " ");
			String job = str.nextToken();

			while (str.hasMoreTokens()) {
				String lang = str.nextToken();
				langScore.put(lang, count);
				count--;
			}

			int score = 0;
			for (int j = 0; j < languages.length; j++) {
				int firstNum = map.get(languages[j]);
				int secondNum = langScore.getOrDefault(languages[j], 0);
				score += (firstNum * secondNum);
			}

			if (score >= maxScore) {
				maxScore = score;
				maxJob = job;
				if (score == maxScore) {
					String[] temp = new String[2];
					temp[0] = maxJob;
					temp[1] = job;
					Arrays.sort(temp);
					maxJob = temp[1];
				}
			}

		}

		return maxJob;
	}

}
