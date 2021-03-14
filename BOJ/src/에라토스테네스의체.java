
public class 에라토스테네스의체 {

	public static void main(String[] args) {

	}

	public boolean isPrime1(int N) {
		for (int i = 2; i < N; i++) {
			if (N % i == 0) { // 하나라도 나뉘는 게 있으면
				return false;
			}
		}
		return true;
	}

	public boolean isPrime2(int N) {
		boolean[] check = new boolean[N + 1]; // 0부터 N까지

		for (int i = 2; i <= N / 2; i++) { // 2부터 N/2까지인 이유 : 배수는 *2가 시작이니까 N/2 * 2 = N으로 N/2+1부터는 할 필요가 없다
			if (!check[i]) {	// 만약 i가 소수이면
				for (int j = i + i; j <= N; j += i) { // i의 배수들을 전부 합성수이다
					check[j] = true;
				}
			}
		}
		
		return !check[N];
	}

}
