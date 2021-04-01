package level2.단체사진찍기;

import java.util.HashMap;

public class Solution {

	public int solution(int n, String[] data) {

		char[] friends = { 'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T' };
		int answer = 0;

		HashMap<Character, Integer> map = new HashMap<>();

		char[][] input = new char[data.length][5];
		for (int i = 0; i < data.length; i++) {
			input[i] = data[i].toCharArray();
		}

		do {
			boolean check = true;

			for (int i = 0; i < len; i++) {
				map.put(friends[i], i);
			}

			for (int i = 0; i < data.length; i++) {
				int me = map.get(input[i][0]);
				int you = map.get(input[i][2]);

				switch (input[i][3]) {
				case '=':
					if (Math.abs(me - you) - 1 != (input[i][4] - '0')) {
						check = false;
					}
					break;
				case '<':
					if (Math.abs(me - you) - 1 >= (input[i][4] - '0')) {
						check = false;
					}
					break;
				case '>':
					if (Math.abs(me - you) - 1 <= (input[i][4] - '0')) {
						check = false;
					}
					break;
				}
				if (!check) {
					break;
				}
			}

			if (check) {
				answer++;
			}
		} while (np(friends));

		return answer;
	}

	int len = 8;

	private boolean np(char[] friends) {

		int i = len - 1;
		while (i > 0 && friends[i - 1] > friends[i]) {
			i--;
		}
		if (i == 0) {
			return false;
		}

		int j = len - 1;
		while (friends[i - 1] > friends[j]) {
			j--;
		}

		char temp = friends[i - 1];
		friends[i - 1] = friends[j];
		friends[j] = temp;

		int k = len - 1;
		while (i < k) {
			temp = friends[i];
			friends[i] = friends[k];
			friends[k] = temp;
			i++;
			k--;
		}

		return true;
	}

}
