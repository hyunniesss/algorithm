package gold3.B1167;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_memory_fail {
	
	static int V;
	static int[][] map;
	static boolean[] check;
	static int max;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		map = new int[V][V];
		check = new boolean[V];
		for(int v=0;v<V;v++) {
			StringTokenizer str= new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(str.nextToken())-1;
			int end = Integer.parseInt(str.nextToken())-1;
			while(end!=-2) {
				map[start][end] = Integer.parseInt(str.nextToken());
				end = Integer.parseInt(str.nextToken())-1;
			}
		} // end input
		
		
		for(int i=0;i<V;i++) {	// 시작 정점
			int sum = 0;// 시작정점부터 거리
			int end = 0;
			check[i] = true;
			dfs(i, sum);
			check[i] = false;
		}
		
		System.out.println(max);
		
	}

	private static void dfs(int start, int sum) {
		
		max = Math.max(sum, max);
		int idx = start;
		for(int i=0;i<V;i++) {
			if(start==i || check[i]) {
				continue;
			}
			if(map[start][idx] < map[start][i]) {
				idx = i;
			}
		}
		if(idx==start) {
			return;
		}
		check[idx] = true;
		dfs(idx, sum + map[start][idx]);
		check[idx] = false;
	}

}
