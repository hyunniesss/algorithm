package silver5.B7568;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class Person implements Comparable<Person> {
		int height;
		int weight;
		int index;

		public Person(int height, int weight, int index) {
			this.height = height;
			this.weight = weight;
			this.index = index;
		}

		@Override
		public int compareTo(Person o) {
			if (this.height > o.height && this.weight > o.weight) {
				return -1;
			} else if (this.height < o.height && this.weight < o.weight) {
				return 1;
			}
			return 0;
		}

	}

	static int N;
	static int[] rank;
	static Person[] people;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine()); // 사람 수
		rank = new int[N];
		people = new Person[N];

		for (int n = 0; n < N; n++) {
			StringTokenizer str = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(str.nextToken()); // 몸무게
			int y = Integer.parseInt(str.nextToken()); // 키
			people[n] = new Person(y, x, n);
		}

		Arrays.sort(people);
		rank[people[0].index] = 1;
		int cnt = 1;

		for (int i = 1; i < N; i++) {
			Person p1 = people[i];
			Person p2 = people[i - 1];

			if (p2.weight <= p1.weight || p2.height <= p1.height) {
				rank[p1.index] = rank[p2.index];
				cnt++;
			} else {
				rank[p1.index] = rank[p2.index] + cnt;
				cnt = 1;
			}
		}

		for (int i = 0; i < N; i++) {
			bw.write(rank[i] + " ");
		}

		bw.flush();

	}

}
