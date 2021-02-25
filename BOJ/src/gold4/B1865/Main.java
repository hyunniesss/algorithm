package gold4.B1865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, W;
	static List<int[]>[] map;
	static boolean[] check;
	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());
		while (TC-- > 0) {

			StringTokenizer str = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(str.nextToken());
			M = Integer.parseInt(str.nextToken());
			W = Integer.parseInt(str.nextToken());

			start();
			int s, e, t;

			for (int i = 0; i < M; i++) {
				str = new StringTokenizer(br.readLine(), " ");
				s = Integer.parseInt(str.nextToken());
				e = Integer.parseInt(str.nextToken());
				t = Integer.parseInt(str.nextToken());

				addList(s, e, t);
			}

			for (int i = 0; i < W; i++) {
				str = new StringTokenizer(br.readLine(), " ");
				s = Integer.parseInt(str.nextToken());
				e = Integer.parseInt(str.nextToken());
				t = -Integer.parseInt(str.nextToken());

				addList(s, e, t);
			}
			
			for(int i=1;i<=N;i++) {
				Collections.sort(map[i], new Comparator<int[]>() {

					@Override
					public int compare(int[] o1, int[] o2) {
						return o1[1] - o2[1];	//오름차순
					}
				});
			}
			
			for(int r=1;r<=N;r++) {
				check = new boolean[N+1];
				bfs(r);
			}

		}
	}

	private static void bfs(int start) {
		queue.clear();
		check[start] = true;
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			
		}
		
	}

	private static void addList(int s, int e, int t) {

		map[s].add(new int[] { e, t });
		map[e].add(new int[] { s, t });

	}

	private static void start() {

		map = new ArrayList[N + 1];
		for (int n = 1; n <= N; n++) {
			map[n] = new ArrayList<>();
		}

	}

}
