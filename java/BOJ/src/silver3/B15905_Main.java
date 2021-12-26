package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B15905_Main {
//	대회의 5등과 푼 문제 수는 같지만 패널티 차이로 수상하지 못한 학생들
//	1. 각 참가자는 해결한 문제 개수와 패널티 총합을 가진다.
//	2. 해결한 문제의 개수가 더 많은 참가자가 더 높은 순위를 가진다.
//	3. 해결한 문제의 수가 같을 때, 패널티 총합이 더 작은 참가자가 더 높은 순위를 가진다.
//	Q. 5등과 해결한 문제 개수가 같지만 수상하지 못하는 학생의 수

	static class Point {
		int cnt; // 푼 문제 수
		int penalty; // 패널티

		public Point(int cnt, int penalty) {
			this.cnt = cnt;
			this.penalty = penalty;
		}

	}

	static Point[] students;
	static int N;
	static final int FIVE = 4;

	public static void main(String[] args) {

		initInput();
		if(N==5) {
			System.out.println(0);
			return;
		}
		Arrays.sort(students, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {

				if (o2.cnt == o1.cnt) { // 푼 문제 수가 같으면
					return Integer.compare(o1.penalty, o2.penalty); // 패널티 오름차순
				}
				return Integer.compare(o2.cnt, o1.cnt); // 푼 문제 수 내림차순
			}
		});

		int now = 5;
		while (now < N && students[now].cnt == students[FIVE].cnt) {	// 학생 수의 범위 중에 5등과 같은 문제수인 동안
			now++;
		}

		System.out.println(now - FIVE - 1);

	}

	private static void initInput() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		int cnt, penalty;
		try {
			N = Integer.parseInt(br.readLine());
			students = new Point[N];
			for (int i = 0; i < N; i++) {
				str = new StringTokenizer(br.readLine(), " ");
				cnt = Integer.parseInt(str.nextToken());
				penalty = Integer.parseInt(str.nextToken());
				students[i] = new Point(cnt, penalty);
			}
		} catch (NumberFormatException | IOException e) {
		}
	}

}
