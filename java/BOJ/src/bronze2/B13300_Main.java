package bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B13300_Main {

	static class Student {
		int sex; // 0 ~ 1
		int year; // 1 ~ 6

		public Student(int sex, int year) {
			this.sex = sex;
			this.year = year;
		}

		@Override
		public boolean equals(Object obj) {
			Student obj_s = (Student) obj;
			return this.year == obj_s.year && this.sex == obj_s.sex;
		}
	}

	static class Input {
		int N; // 학생수
		int K; // 한 방의 최대 인원수
		Student[] stdents; // 학생정보

		public Input(int n, int k, Student[] stdents) {
			N = n;
			K = k;
			this.stdents = stdents;
		}
	}

	public static void main(String[] args) {

		Input input = initInput();

		int room = 0;
		for (int i = 0; i < input.N; i++) {
			int cnt = 1;
			while (cnt < input.K && i + 1 < input.N && input.stdents[i].equals(input.stdents[i + 1])) {
				cnt++;
				i++;
			}
			room++;
		}
		System.out.println(room);

	}

	private static Input initInput() {

		Input inp = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		try {
			str = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(str.nextToken());
			int k = Integer.parseInt(str.nextToken());
			Student[] stdents = new Student[n];
			for (int i = 0; i < n; i++) {
				str = new StringTokenizer(br.readLine(), " ");
				int sex = Integer.parseInt(str.nextToken());
				int year = Integer.parseInt(str.nextToken());
				stdents[i] = new Student(sex, year);
			}
			Arrays.sort(stdents, new Comparator<Student>() {

				@Override
				public int compare(Student o1, Student o2) {
					// year 정렬
					// year 같으면 sex 정렬
					if (o1.year == o2.year) {
						return Integer.compare(o1.sex, o2.sex);
					}
					return Integer.compare(o1.year, o2.year);
				}
			});
			inp = new Input(n, k, stdents);
		} catch (IOException e) {
		}

		return inp;
	}

}
