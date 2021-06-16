package gold5.B19640;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K;

	static class Man implements Comparable<Man> {

		int idx;
		int m;
		int d;
		int h;

		public Man(int idx, int m, int d, int h) {
			this.idx = idx;
			this.m = m;
			this.d = d;
			this.h = h;
		}

		@Override
		public int compareTo(Man o) {
			if (this.d != o.d) {
				return Integer.compare(o.d, this.d);
			}
			if (this.h != o.h) {
				return Integer.compare(o.h, this.h);
			}
			return Integer.compare(this.m, o.m);
		}

	}

	static Queue<Man>[] queue;
	static PriorityQueue<Man> pq = new PriorityQueue<>();

	public static void main(String[] args) {

		initMap();

		int next = -1;
		int answer = -1;
		int idx = 1;
		while (idx <= M && !queue[idx].isEmpty()) {
			pq.offer(queue[idx++].poll());
		}

		while (next != K) {
			answer++;
			Man temp = pq.poll();
			next = temp.idx;

			if (queue[temp.m].isEmpty()) {
				continue;
			}
			pq.offer(queue[temp.m].poll());
		}

		System.out.println(answer);
	}

	private static void initMap() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		try {
			str = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(str.nextToken());
			M = Integer.parseInt(str.nextToken());
			queue = new LinkedList[M + 1];
			for (int i = 1; i <= M; i++) {
				queue[i] = new LinkedList<>();
			}
			K = Integer.parseInt(str.nextToken()) + 1; // 데카 위치
			int idx = 1;
			for (int i = 1; i <= N; i++) {
				str = new StringTokenizer(br.readLine(), " ");
				int d = Integer.parseInt(str.nextToken());
				int h = Integer.parseInt(str.nextToken());
				queue[idx].offer(new Man(i, idx, d, h));
				idx = idx == M ? 1 : idx + 1;
			}

		} catch (IOException e) {
		}

	}

}
