package level1.콜라츠추측;

public class Solution {

	public static void main(String[] args) {
		System.out.println(solution(6));
		System.out.println(solution(16));
		System.out.println(solution(626331));
	}

	public static int solution(int num) {
		int answer = 0;
		while (answer < 500 && num > 1) {
			answer++;
			if (num % 2 == 0) {
				num /= 2;
			} else {
				num = num * 3 + 1;
			}
		}
//		System.out.println(num);
		return num == 1 ? answer : -1;
	}

}
