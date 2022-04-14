package level2.N개의최소공배수;

import java.util.Arrays;

class Solution {
	public int solution(int[] arr) {
		int answer = 1; // 계속 곱할 거니까 초기값 = 1
		int LEN = arr.length;
		int flag = 0;
				//, MAX = (int) Math.pow(2, LEN);
		Arrays.sort(arr);
		int mod = 2;
		while ( flag < (int) Math.pow(2, LEN) - 1 ) {
				// mod <= arr[LEN - 1]) {
			boolean test = false;
			for (int i = 0; i < LEN; i++) {
				if ((flag & (1 << i)) != 0) { // 끝난 숫자
					continue;
				}
				if (arr[i] == 1) {
					flag |= (1 << i); // 끝난 수로 처리
					continue;
				}
				if (arr[i] % mod == 0) { // 나눌 수 있으면
					if ((arr[i] /= mod) == 1) { // 나눈 후 몫이 1이면 끝난 숫자
						flag |= (1 << i);
					}
					test = true; // 나눈 적 있으면 최소공배수에 곱해야됨
				}
			}
			if (test) {
				answer *= mod;
//				Arrays.sort(arr);
				mod = 2;
			} else {
				mod++;
			}
		}

		return answer;
	}
}
