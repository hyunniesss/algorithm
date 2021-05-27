package level2.일이사나라의숫자;

public class Solution {

	public static void main(String[] args) {
		System.out.println(solution(1));
		System.out.println(solution(2));
		System.out.println(solution(3));
		System.out.println(solution(4));
	}

	public static String solution(int n) {
//        String answer=Integer.parseInt(n+"",3)+"";

//        System.out.println("ANSWER : "+answer);
//        answer = answer.replaceAll("2", "4");
//        answer = answer.replaceAll("1", "2");
//        answer = answer.replaceAll("0", "1");
		StringBuilder answer = new StringBuilder();
		while (n > 0) {
			n--;
			int temp = n % 3;
			switch (temp) {
			case 0:
				answer.insert(0, 1);
				break;
			case 1:
				answer.insert(0, 2);
				break;
			case 2:
				answer.insert(0, 4);
				break;
			}
			n /= 3;
		}
		return answer.toString();
	}

}
