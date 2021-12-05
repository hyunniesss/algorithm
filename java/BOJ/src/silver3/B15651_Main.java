package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15651_Main {
	
	static int[] arr;	// 고른 M개의 수
	static int N,M;
	static StringBuilder answer = new StringBuilder();
	
	public static void main(String[] args) {
		
//		서로 다른 N개의 수 중 중복허용으로 M개의 수 => 중복순열
		
		initInput();
		dfs(0);
		System.out.println(answer.toString());
		
	}

	private static void dfs(int cnt) {
		if(cnt==M) {
//			System.out.println(Arrays.toString(arr));
			print();
			return;
		}
		for(int i=1;i<=N;i++) {
			arr[cnt] = i;
			dfs(cnt+1);
		}
		
	}

	private static void print() {
		for(int a : arr) {
			answer.append(a+" ");
		}
		answer.append("\n");
	}

	private static void initInput() {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer str = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(str.nextToken());
			M = Integer.parseInt(str.nextToken());
			arr = new int[M];
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		
	}

}
