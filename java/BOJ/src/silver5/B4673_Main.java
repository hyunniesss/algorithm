package silver5;

/**
 * 
 * @author hyunhee 
 * d(n) = n과 n의 각 자리수를 더하는 함수 
 * n : d(n)의 생성자 셀프넘버 : 생성자가 없는 숫자 
 * Q.10000보다 작거나 같은 셀프 넘버를 한 줄에 하나씩 출력
 */

public class B4673_Main {

	static final int LEN = 10001;
	static boolean[] isSelfnum = new boolean[LEN];

	public static void main(String[] args) {

		for (int i = 1; i < LEN; i++) {
			int temp = i, next = i;
			while (temp != 0) {
				next += (temp % 10);
				temp /= 10;
			}
			if (next < LEN) {
				isSelfnum[next] = true;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < LEN; i++) {
			sb.append(isSelfnum[i] ? "" : i + "\n");
		}

		System.out.println(sb.toString());

	}

}
