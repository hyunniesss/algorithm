package line202103;

import java.util.HashMap;
import java.util.Map;

public class Q2 {

	public static void main(String[] args) {

	}

	public int[] solution(String inp_str) {

		Map<Character, Integer> map = new HashMap<>();
		boolean[] rules = new boolean[6];

		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String number = "0123456789";
		String special = "~!@#$%^&*";

		// 1.
		if (inp_str.length() < 8 || inp_str.length() > 15) {
			rules[1] = true;
		}

		boolean[] check = new boolean[4];
		int count = 0;
		char bef = ' ';

		// 2.
		for (int i = 0; i < inp_str.length(); i++) {
			char temp = inp_str.charAt(i);
			map.put(temp, map.getOrDefault(temp, 0) + 1);
			if (map.get(temp) > 4) {
				rules[5] = true;
			}
			if (alphabet.contains(temp + "")) {
				check[0] = true;
			} else if (alphabet.toLowerCase().contains(temp + "")) {
				check[1] = true;
			} else if (number.contains(temp + "")) {
				check[2] = true;
			} else if (special.contains(temp + "")) {
				check[3] = true;
			} else {
				rules[2] = true;
			}
			if (!rules[4]) {
				if (bef == temp) {
					count++;
					if (count == 4) {
						rules[4] = true;
					}
				} else {
					bef = temp;
					count = 1;
				}
			}

		}
		count = 0;
		// 3.
		for (int i = 0; i < check.length; i++) {
			if (check[i]) {
				count++;
			}
		}
		if (count < 3) {
			rules[3] = true;
		}

		int len = 0;
		for (int i = 1; i <= 5; i++) {
			if (rules[i]) {
				len++;
			}
		}

		if (len == 0) {
			return new int[] { 0 };
		}
		int[] answer = new int[len];

		for (int i = 1, l = 0; i <= 5; i++) {
			if (rules[i]) {
				answer[l] = i;
				l++;
			}
		}
		
		return answer;

	}

}
