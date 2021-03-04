package silver2.B11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class B11724_DFS {

	static List<Integer>[] map;
	static boolean[] check;
	static int count;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());

		map = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			map[i] = new ArrayList<>();
		}
		for (int m = 0; m < M; m++) {
			str = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			map[a].add(b);
			map[b].add(a);
		} // 입력 끝 UF 시작
		check = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			if (!check[i]) {
				check[i] = true;
				dfs(i);
				count++;
			}
		}
		
		System.out.println(count);

	}

	private static void dfs(int parent) {
		for (int i = 0; i < map[parent].size(); i++) {
			int temp = map[parent].get(i);
			if (!check[temp]) {
				check[temp] = true;
				dfs(temp);
			}
		}
	}

}
