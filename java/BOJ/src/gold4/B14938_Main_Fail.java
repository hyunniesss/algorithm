package gold4;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B14938_Main_Fail {
	static int N, M, R;
	static int[] map;
	static ArrayList<ArrayList<Edge>> list;

	static class Point implements Comparable<Point> {
		int start;
		int v;
		int item;
		int m;
//        boolean[] check;

//        public Point(int start, int v, int item, int m, boolean[] check) {
//            this.start = start;
//            this.v = v;
//            this.item = item;
//            this.m = m;
//            this.check = Arrays.copyOf(check, check.length);
//        }

		public Point(int start, int v, int item, int m) {
			super();
			this.start = start;
			this.v = v;
			this.item = item;
			this.m = m;
		}

		@Override
		public int compareTo(Point o) {
			if (this.item == o.item) {
				return this.m - o.m; // 거리 오름차순
			}
			return o.item - this.item; // 아이템 내림차순
		}
	}

	static class Edge {
		int dest;
		int distance;

		public Edge(int dest, int distance) {
			this.dest = dest;
			this.distance = distance;
		}
	}

	static int[][] dp;

	public static void main(String[] args) {
		initInput();
		findItem();
		int max = findMaxVal(dp);
		System.out.println(max);
	}

	private static int findMaxVal(int[][] dp) {
		int max = -1;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				max = Math.max(dp[i][j], max);
			}
		}
		return max;
	}

	private static void findItem() {
		for (int[] a : dp) {
			Arrays.fill(a, -1);
		}
		PriorityQueue<Point> pq = initiatePQ();
		while (!pq.isEmpty()) {
			Point cur = pq.poll(); // start, v, item, m, check
			// 인접리스트 확인
			for (Edge e : list.get(cur.v)) {
//				if (cur.check[e.dest] || cur.m + e.distance > M) { // 가본 곳 || 못가는 곳이면 continue
//					continue;
//				}
				if(cur.m + e.distance > M) {
					continue;
				}
//				cur.check[e.dest] = true;
				int nextItem = cur.item + map[e.dest];
				dp[cur.start][e.dest] = Math.max(nextItem, dp[cur.start][e.dest]);
				pq.offer(new Point(cur.start, e.dest, nextItem, cur.m + e.distance));
//				pq.offer(new Point(cur.start, e.dest, nextItem, cur.m + e.distance, cur.check));
//				cur.check[e.dest] = false;
			}
		}
	}

	private static PriorityQueue<Point> initiatePQ() {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			boolean[] check = new boolean[N + 1];
			check[i] = true;
			dp[i][i] = map[i];
//			pq.offer(new Point(i, i, map[i], 0, check));
		}
		return pq;
	}

	private static void initInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		try {
			str = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(str.nextToken());
			M = Integer.parseInt(str.nextToken());
			R = Integer.parseInt(str.nextToken());
			map = new int[N + 1];
			str = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= N; i++) {
				map[i] = Integer.parseInt(str.nextToken());
			}
			list = new ArrayList<>();
			for (int i = 0; i <= N; i++) {
				list.add(new ArrayList<>());
			}

			for (int i = 0; i < R; i++) {
				str = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(str.nextToken());
				int b = Integer.parseInt(str.nextToken());
				int d = Integer.parseInt(str.nextToken());
				list.get(a).add(new Edge(b, d));
				list.get(b).add(new Edge(a, d));
			}

			dp = new int[N + 1][N + 1];
		} catch (Exception e) {
		}
	}
}
