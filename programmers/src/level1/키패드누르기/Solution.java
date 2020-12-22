package level1.키패드누르기;

public class Solution {

	public static void main(String[] args) {
		int[] numbers = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
		String hand = "right";
		System.out.println(solution(numbers, hand));
		numbers = new int[] { 7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2 };
		hand = "left";
		System.out.println("LRLLRRLLLRR".equals(solution(numbers, hand)));
		System.out.println(solution(numbers, hand));
		System.out.println("LRLLRRLLLRR");
	}

	public static String solution(int[] numbers, String hand) {
		int[][] pos = new int[2][2]; // [0] : left row, col
										// [1] : right row, col
		pos[0][0] = 3;
		pos[0][1] = 0;
		pos[1][0] = 3;
		pos[1][1] = 2;
		StringBuilder answer = new StringBuilder();
		for (int i : numbers) {
			boolean[][] check = new boolean[4][3];
			switch (i) {
			case 1:
				answer.append("L");
				pos[0][0] = 0;
				pos[0][1] = 0;
				break;
			case 4:
				answer.append("L");
				pos[0][0] = 1;
				pos[0][1] = 0;
				break;
			case 7:
				answer.append("L");
				pos[0][0] = 2;
				pos[0][1] = 0;
				break;
			case 3:
				answer.append("R");
				pos[1][0] = 0;
				pos[1][1] = 2;
				break;
			case 6:
				answer.append("R");
				pos[1][0] = 1;
				pos[1][1] = 2;
				break;
			case 9:
				answer.append("R");
				pos[1][0] = 2;
				pos[1][1] = 2;
				break;
			default:
				System.out.println("i는 " + i);
				i = i == 0 ? 3 : i / 3;
				int left = Math.abs(pos[0][0] - i) + Math.abs(pos[0][1] - 1);
				int right = Math.abs(pos[1][0] - i) + Math.abs(pos[1][1] - 1);
				if (left == right) {
					answer.append(hand.toUpperCase().charAt(0));
					if ('l' == hand.charAt(0)) {
						pos[0][0] = i;
						pos[0][1] = 1;
					} else {
						pos[1][0] = i;
						pos[1][1] = 1;
					}
				} else if (left > right) {
					answer.append("R");
					pos[1][0] = i;
					pos[1][1] = 1;
				} else {
					answer.append("L");
					pos[0][0] = i;
					pos[0][1] = 1;
				}
			}
		}
		return answer.toString();
	}

}
