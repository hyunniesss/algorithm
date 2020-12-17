package silver3.B2606;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author hyunhee 컴퓨터의 수는 100 이하
 * 
 */

public class Main {

	static int N;
	static boolean[] check;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		check = new boolean[N];
		List<Integer>[] node = new ArrayList[N];
		for (int n = 0; n < N; n++) {
			node[n] = new ArrayList<Integer>();
		}
		int M = Integer.parseInt(br.readLine());
		for (int m = 0; m < M; m++) {
			StringTokenizer str = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(str.nextToken()) - 1;
			int e = Integer.parseInt(str.nextToken()) - 1;
			node[s].add(e);
			node[e].add(s);
		}
		check[0] = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(0);
		int cnt = 0;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int i = 0; i < node[cur].size(); i++) {
				int next = node[cur].get(i);
				if (!check[next]) {
					check[next] = true;
					queue.offer(next);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

}
