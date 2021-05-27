package level1.크레인인형뽑기;

import java.util.Stack;

public class Solution {

	public int solution(int[][] board, int[] moves) {
		int answer = 0;

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < moves.length; i++) {
			int c = moves[i] - 1;
			for (int r = 0; r < board.length; r++) {
				if (board[r][c] == 0) {
					continue;
				}
				int temp = board[r][c];
				board[r][c] = 0;
				if (stack.isEmpty() || stack.peek() != temp) {
					stack.push(temp);
				} else {
					stack.pop();
					answer += 2;
				}
				break;
			}
		}

		return answer;
	}

}
