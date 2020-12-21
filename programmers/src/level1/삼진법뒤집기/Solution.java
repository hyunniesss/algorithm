package level1.삼진법뒤집기;

/**
 * @author hyunhee n은 1 이상 100,000,000 이하인 자연수
 */

public class Solution {

	public static void main(String[] args) {

		System.out.println(solution(45));

	}

	public static int solution(int n) {
		int answer = 0;
//        System.out.println(Integer.parseInt(n+"", 3));
//        StringBuilder three = new StringBuilder(Integer.parseInt(n+"", 3)+"");
//        three = three.reverse();
//        for(int i=three.length()-1;i>=0;i--) {
//        	answer = answer*3 + three.charAt(i)-'0';
//        }
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			sb.append(n % 3);
			n /= 3;
		}
//		System.out.println(sb);
		sb = sb.reverse();
//		System.out.println(sb);
		for (int i = sb.length() - 1; i >= 0; i--) {
			answer *= 3;
			answer += sb.charAt(i) - '0';
		}
		return answer;
	}

}
