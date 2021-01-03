package silver1.B1011;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_timeout {

	static int T;
	static int Y, answer;
	static StringBuilder sb = new StringBuilder();
	static Queue<Point> queue = new LinkedList<>();

	static class Point {
		long cur;
		long Kn;
		int cnt;

		public Point(long cur, long Kn, int cnt) {
			this.cur = cur;
			this.Kn = Kn;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer str = new StringTokenizer(br.readLine(), " ");
			Y = Integer.parseInt(str.nextToken());
			Y = Integer.parseInt(str.nextToken()) - Y - 1;
			// BFS
			queue.clear();
			queue.offer(new Point(1, 1, 1));
			while (!queue.isEmpty()) {
				Point point = queue.poll();
				if (point.cur == Y) {
					sb.append(point.cnt + 1).append("\n");
					break;
				}
				long temp = point.cur + point.Kn + 1;
				if (point.Kn + 1 > 0 && temp <= Y) {
					queue.offer(new Point(temp, point.Kn + 1, point.cnt + 1));
				}
				temp = point.cur + point.Kn;
				if (point.Kn > 0 && temp <= Y) {
					queue.offer(new Point(temp, point.Kn, point.cnt + 1));
				}
				temp = point.cur + point.Kn - 1;
				if (point.Kn - 1 > 0 && temp <= Y) {
					queue.offer(new Point(temp, point.Kn - 1, point.cnt + 1));
				}
			}

		}

		System.out.println(sb);

	}

}
