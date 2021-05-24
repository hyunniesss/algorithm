package 가희배코딩테스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q8_가희와프로세스2 {

	static int Q, N;

	static class Process implements Comparable<Process> {

		long id;
		long time;
		long prior;

		public Process(long id, long time, long prior) {
			this.id = id;
			this.time = time;
			this.prior = prior;
		}

		@Override
		public int compareTo(Process o) {
			if (this.prior != o.prior) {
				return Long.compare(o.prior, this.prior); // 우선순위 내림차순
			}
			return Long.compare(this.id, o.id); // 아이디 오름차순
		}

		@Override
		public String toString() {
			return "Process [id=" + id + ", time=" + time + ", prior=" + prior + "]";
		}

	}

	static PriorityQueue<Process> al = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		str = new StringTokenizer(br.readLine(), " ");
		Q = Integer.parseInt(str.nextToken());
		N = Integer.parseInt(str.nextToken());
		for (int i = 0; i < N; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			long id = Long.parseLong(str.nextToken());
			long time = Long.parseLong(str.nextToken());
			long prior = Long.parseLong(str.nextToken());
			Process next = new Process(id, time, prior);
			al.offer(next);
		}
		StringBuilder sb = new StringBuilder();
		long t = 0;
		for (int i = 0; i < Q; i++) {
			String input = br.readLine();
			long T = Long.parseLong(input);
			while (t < T) {
				if (al.size() == 1) {
					answer = al.peek().id;
					break;
				}
				process();
//				System.out.println("t = " + t + " " + Arrays.toString(al.toArray()));
				t++;
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());

	}

	static long answer;

	private static void process() {

		Process cur = al.poll();
		answer = cur.id;
		if (--cur.time == 0) {
			return;
		}
		--cur.prior;
		al.offer(cur);

	}

}
