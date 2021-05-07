package level2.수식최대화;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	final int N = 3;
	int[] arr = new int[N];
	String operations = "+-*";
	ArrayList<Character> opList = new ArrayList<>();
	ArrayList<Long> numList = new ArrayList<>();

	public long solution(String expression) {
		StringTokenizer str = null;
		long answer = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = i;
		}

		do {
			opList.clear();
			numList.clear();
			str = new StringTokenizer(expression, "01233456789"); // 연산자
			while (str.hasMoreTokens()) {
				opList.add(str.nextToken().charAt(0));
			}
			str = new StringTokenizer(expression, operations); // 숫자
			while (str.hasMoreTokens()) {
				numList.add(Long.parseLong(str.nextToken()));
			}
			answer = Math.max(answer, calc());
		} while (NP());

		return answer;
	}

	private long calc() {

		for (int i = 0; i < N; i++) {
			char op = operations.charAt(arr[i]);
			int idx;
			while ((idx = opList.indexOf(op)) >= 0) {
				opList.remove(idx);
				long a = numList.remove(idx);
				long b = numList.remove(idx);
				switch (op) {
				case '+':
					numList.add(idx, a + b);
					break;
				case '-':
					numList.add(idx, a - b);
					break;
				case '*':
					numList.add(idx, a * b);
				}
			}
		}

		return Math.abs(numList.get(0));
	}

	private boolean NP() {

		int i = N - 1;
		while (i > 0 && arr[i - 1] > arr[i]) {
			i--;
		}
		if (i == 0) {
			return false;
		}

		int j = N - 1;
		while (arr[i - 1] > arr[j]) {
			j--;
		}

		swap(i - 1, j);

		int k = N - 1;
		while (i < k) {
			swap(i++, k--);
		}
		return true;
	}

	private void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

}
