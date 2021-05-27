package permutationAndcombination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class PermutationAndCombination {

	static LinkedList<Integer> list = new LinkedList<>();
	static int totalCnt;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int R = Integer.parseInt(br.readLine());

		permutation(N, R); // 중복 O
		System.out.println(totalCnt);
		totalCnt = 0;

		list.clear();
		permutation(N, R, 0); // 중복 X
		System.out.println(totalCnt);
		totalCnt = 0;

		list.clear();
		combination(N, R, 1);
		System.out.println(totalCnt);

	}

	private static void combination(int N, int R, int cur) {

		if (R == 0) {
			System.out.println(Arrays.toString(list.toArray()));
			totalCnt++;
			return;
		}
		if (cur > N) {
			return;
		}

		combination(N, R, cur + 1);
		list.add(cur);
		combination(N, R - 1, cur + 1);
		list.removeLast();
	}

	private static void permutation(int N, int R, int flag) {

		if (R == 0) {
			System.out.println(Arrays.toString(list.toArray()));
			totalCnt++;
			return;
		}

		for (int i = 1; i <= N; i++) {
			if ((flag & (1 << i)) == 0) {
				list.add(i);
				permutation(N, R - 1, flag | (1 << i));
				list.removeLast();
			}
		}

	}

	private static void permutation(int N, int R) {
		if (R == 0) {
			System.out.println(Arrays.toString(list.toArray()));
			totalCnt++;
			return;
		}

		for (int i = 1; i <= N; i++) {
			list.add(i);
			permutation(N, R - 1);
			list.removeLast();
		}

	}

}
