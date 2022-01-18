package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14496_Main {

	static int start, end; // 출발지, 도착지 시작은 1
	static int N, M; // N개의 문자, M개의 치환
	static ArrayList<ArrayList<Integer>> list;

	static int[] Dijkstra;

	static class Point {
		int n;
		int price;

		public Point(int n, int price) {
			this.n = n;
			this.price = price;
		}
	}

	public static void main(String[] args) {
		initInput();
		int answer = replaceAlphabet(start, end);
		System.out.println(answer);
	}

	private static int replaceAlphabet(int start, int end) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(start, 0)); // 시작점
		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			for (int y : list.get(cur.n)) {
				if (Dijkstra[y] == -1) {
					queue.offer(new Point(y, Dijkstra[y] = cur.price + 1));
					continue;
				}
				if (Dijkstra[y] > cur.price + 1) {
					queue.offer(new Point(y, Dijkstra[y] = cur.price + 1));
					continue;
				}

			}
		}
		return Dijkstra[end];
	}

	private static void initInput() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		try {
			str = new StringTokenizer(br.readLine(), " ");
			start = Integer.parseInt(str.nextToken());
			end = Integer.parseInt(str.nextToken());
			str = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(str.nextToken());
			M = Integer.parseInt(str.nextToken());
			list = new ArrayList<>();
			for (int i = 0; i <= N; i++) {
				list.add(new ArrayList<>());
			}

			for (int i = 0; i < M; i++) {
				str = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(str.nextToken());
				int y = Integer.parseInt(str.nextToken());
				list.get(x).add(y);
				list.get(y).add(x);
			}
			Dijkstra = new int[N + 1];
			Arrays.fill(Dijkstra, -1);
			Dijkstra[start] = 0;
		} catch (IOException e) {
		}

	}

}
