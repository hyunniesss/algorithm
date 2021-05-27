package level3.불량사용자;

public class Solution {

	int N, M;
	int answer = 0;
	String[] a, b;

	public int solution(String[] user_id, String[] banned_id) {
		a = user_id;
		b = banned_id;
		N = user_id.length;
		M = banned_id.length;

//		1. combination으로 user_id에서 banned_id 개수만큼 골라
		combi(new int[M], 0, 0);
//		2. 조건에 맞으면 카운트

		return answer;
	}

	private boolean check(int i, int j) {
		if (b[j].length() != a[i].length()) {
			return false;
		}
		for (int ii = 0; ii < a[i].length(); ii++) {
			if (b[j].charAt(ii) == '*') {
				continue;
			}
			if (b[j].charAt(ii) == a[i].charAt(ii)) {
				continue;
			}
			return false;
		}

		return true;
	}

	private void combi(int[] arr, int cur, int cnt) {

		if (cnt == M) {
			if (test(arr)) {
				answer++;
			}
			return;
		}

		for (int i = cur; i < N; i++) {
			arr[cnt] = i;
			combi(arr, i + 1, cnt + 1);
		}

	}

	private boolean test(int[] arr) {
		boolean[] check = new boolean[M];	// banned_id

		for (int j = 0; j < M; j++) {	// j가 후보 아이디
			for (int i = 0; i < M; i++) {	// i가 banned_id
				if (!check[i] && check(arr[j], i)) {
					check[i] = true;
					continue;
				}
			}
		}

		for (int i = 0; i < M; i++) {
			if (!check[i]) {
				return false;
			}
		}
		return true;

	}

}
