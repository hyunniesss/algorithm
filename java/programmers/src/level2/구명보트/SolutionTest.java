package level2.구명보트;

public class SolutionTest {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] people = { 70, 50, 80, 50 };
		int limit = 100;
		System.out.println(sol.solution(people, limit));
		people = new int[] { 70, 80, 50 };
		System.out.println(sol.solution(people, limit));
	}

}
