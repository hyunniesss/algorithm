package level3.네트워크;

public class Solution_DFS {
	
	public static void main(String[] args) {
		
		int n = 3;
		int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		System.out.println(solution(n, computers));
		n = 3;
		computers = new int[][] { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } };
		System.out.println(solution(n, computers));
	
	}

	static boolean[] check;
	
	private static int solution(int n, int[][] computers) {
		check = new boolean[computers.length];
		int answer=0;
		for(int i=0;i<computers.length;i++) {
			if(!check[i]) {
				check[i] = true;
				dfs(i, computers);
				answer++;
			}
		}
		
		return answer;
	}

	private static void dfs(int start, int[][] computers) {
		for(int end=0;end<computers.length;end++) {
			if(computers[start][end]==1 && !check[end]) {
				check[end] = true;
				dfs(end, computers);
			}
		}
	}

}
