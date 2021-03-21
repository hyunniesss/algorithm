package level2.수식최대화;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	String[] op = { "+", "-", "*" };
	int[] priority;

	public long solution(String expression) {
		long answer = -1;
		priority = new int[] { 1, 2, 3 };

		do {
			StringTokenizer numberSTR = new StringTokenizer(expression, "+-*");
			StringTokenizer operationSTR = new StringTokenizer(expression, "0123456789");

			List<String> exp = new ArrayList<>();
			while (operationSTR.hasMoreTokens()) {
				exp.add(numberSTR.nextToken());
				exp.add(operationSTR.nextToken());
			}
			exp.add(numberSTR.nextToken());

			for (int i = 0; i < 3; i++) {
				String operation = op[priority[i] - 1];

				int idx = exp.indexOf(operation);
				while (idx >= 0) {
					long num2 = Long.parseLong(exp.remove(idx + 1));
					long num1 = Long.parseLong(exp.remove(idx - 1));
					switch (operation) {
					case "+":
						num1 += num2;
						break;
					case "-":
						num1 -= num2;
						break;
					case "*":
						num1 *= num2;
					}
					exp.add(idx - 1, num1 + "");
					exp.remove(idx);
					idx = exp.indexOf(operation);
				}

			}

			answer = Math.max(answer, Math.abs(Long.parseLong(exp.get(0))));

		} while (nextPermutation());

		return answer;
	}

	private boolean nextPermutation() {

		// 1. 꼭짓점(i)찾기
		int i = 2;
		while (i > 0 && priority[i - 1] >= priority[i]) {
			--i;
		}
		if (i == 0) {
			return false;
		}

		// 2. 꼭지점과 맞바꿀 j 찾기
		int j = 2;
		while (priority[i - 1] >= priority[j]) {
			j--;
		}

		// 3. i-1랑 j 교환
		int temp = priority[i - 1];
		priority[i - 1] = priority[j];
		priority[j] = temp;

		// 4. i <=> k
		int k = 2;
		while (i < k) {
			temp = priority[i];
			priority[i] = priority[k];
			priority[k] = temp;
			i++;
			k--;
		}

		return true;
	}

}
