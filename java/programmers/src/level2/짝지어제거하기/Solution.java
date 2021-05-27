package level2.짝지어제거하기;

import java.util.Stack;

public class Solution {

	public int solution(String s) {

//		for (int i = 1; i < s.length(); i++) {
//			if (s.charAt(i) == s.charAt(i - 1)) {
//				s = s.substring(0, i - 1) + s.substring(i + 1);
//				i = 0;
//			}
//		}

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
				stack.pop();
			} else {
				stack.push(s.charAt(i));
			}
		}

		return stack.isEmpty() ? 1 : 0;
	}

}
