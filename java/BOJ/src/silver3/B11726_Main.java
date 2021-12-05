package silver3;

import java.util.Scanner;

public class B11726_Main {
	
	public static void main(String[] args) {
		int n=-1;
		try(Scanner sc = new Scanner(System.in)){
			n = sc.nextInt();
		}
		
		int result = dfs(n);
		System.out.println(result);
		
	}

	private static int dfs(int n) {
		if(n==0) {
			return 1;
		}
		if(n<=2) {
			return n;
		}
		return dfs(n-1)%10007 + dfs(n-2)%10007;
		
	}

}
