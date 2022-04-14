package silver5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1417_Main {

	static class Input {
		int N;
		Applicant[] aplcnt;

		public Input(int n, Applicant[] aplcnt) {
			N = n;
			this.aplcnt = aplcnt;
		}
	}

	static class Applicant implements Comparable<Applicant> {
		int number;
		int voteCount;

		public Applicant(int number, int voteCount) {
			this.number = number;
			this.voteCount = voteCount;
		}

		@Override
		public int compareTo(Applicant o) {
			if (this.voteCount == o.voteCount) {
				return Integer.compare(o.number, this.number); // 내림차순 정렬
			}
			return Integer.compare(o.voteCount, this.voteCount); // 내림차순 정렬
		}
	}

	public static void main(String[] args) {
		Input input = initInput();
		int answer = getMini(input.aplcnt);
		System.out.println(answer);
	}

	private static int getMini(Applicant[] aplcnt) {
		int answer = 0;
		while (aplcnt[0].number != 1) {
			int me = 0;
			while (aplcnt[me].number != 1) {
				me++;
			}
			aplcnt[me].voteCount++;
			aplcnt[0].voteCount--;
			Arrays.sort(aplcnt);
			answer++;
		}
		return answer;
	}

	private static Input initInput() {
		Input input = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer str = null;
		try {
			int n = Integer.parseInt(br.readLine());
			Applicant[] aplcnt = new Applicant[n]; // [0] : 번호, [1] : 득표수
//			str = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n; i++) {
				int number = i + 1;
				int voteCount = Integer.parseInt(br.readLine());
				aplcnt[i] = new Applicant(number, voteCount);
			}
			Arrays.sort(aplcnt);
//			System.out.println(Arrays.toString(aplcnt));
			input = new Input(n, aplcnt);
		} catch (Exception e) {
		}
		return input;
	}

}
