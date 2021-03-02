package L934;

public class SolutionTest {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] A = { { 0, 1 }, { 1, 0 } };
		System.out.println(s.shortestBridge(A));

		A = new int[][] { { 0, 1, 0 }, { 0, 0, 0 }, { 0, 0, 1 } };
		System.out.println(s.shortestBridge(A));

		A = new int[][] { { 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 0, 0, 1 },
				{ 1, 1, 1, 1, 1 } };
		System.out.println(s.shortestBridge(A));

	}

}
