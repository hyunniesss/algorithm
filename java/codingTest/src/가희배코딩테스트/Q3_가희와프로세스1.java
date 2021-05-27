package 가희배코딩테스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q3_가희와프로세스1 {

	static int T, N;

	static class Process implements Comparable<Process> {
		int id;
		int time;
		int prior;

		public Process(int id, int time, int prior) {
			this.id = id;
			this.time = time;
			this.prior = prior;
		}

		@Override
		public int compareTo(Process o) {
			if (this.prior != o.prior) {
				return Integer.compare(o.prior, this.prior); // 우선순위 내림차순
			}
			return Integer.compare(this.id, o.id); // 아이디 오름차순
		}

	}

	static PriorityQueue<Process> al = new PriorityQueue<>();

	public static void main(String[] args) {

		init();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			Process cur = al.poll();
			sb.append(cur.id).append("\n");
			if (--cur.time == 0) {
				continue;
			}
			--cur.prior;
			al.offer(cur);
		}

		System.out.println(sb.toString());

	}

	private static void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		try {
			str = new StringTokenizer(br.readLine(), " ");
			T = Integer.parseInt(str.nextToken());
			N = Integer.parseInt(str.nextToken());
			for (int i = 0; i < N; i++) {
				str = new StringTokenizer(br.readLine(), " ");
				int id = Integer.parseInt(str.nextToken());
				int time = Integer.parseInt(str.nextToken());
				int prior = Integer.parseInt(str.nextToken());
				al.offer(new Process(id, time, prior));
			}
		} catch (Exception e) {
		}
	}

}
