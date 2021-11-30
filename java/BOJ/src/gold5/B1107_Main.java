package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1107_Main {

	static final int MAX = 1000001;
	static int N; // 이동하려는 채널
	static boolean[] number = new boolean[10]; // 사용할 수 없는 번호(true)

	public static void main(String[] args) {

		initInput();
		int cur = 100; // 현재 채널
		if (N == cur) { // 이동하려는 채널이 현재 채널인 경우
			System.out.println(0);
			return;
		}
		// 방법 1. 현재채널에서 + 또는 - 만으로 이동
		int min = Math.abs(N - cur);
/*
//		방법 2. 현재 리모컨으로 숫자버튼만을 통해 이동할 수 있는 경우
		int temp = N, cnt = 0;
		while (temp > 0) {
			if (number[temp % 10]) {
				cnt = -1;
				break;
			}
			cnt++;
			temp /= 10;
		}
		min = cnt == -1 ? min : Math.min(cnt, min);

		// 방법 3. 현재 리모컨으로 유사한 위치로 이동
		temp = N;
		cnt = 0;
		int remoteNum = 0;
		while (temp > 0) {
			if (number[temp % 10]) {
				int a = temp % 10;
				while (a >= 0 && number[a]) {
					a--;
				}
				if (a < 0) {
					a = temp % 10;
					while (a < 10 && number[a]) {
						a++;
					}
				}
				remoteNum = a * (int) Math.pow(10, cnt) + remoteNum;
			} else {
				remoteNum = (temp % 10) * (int) Math.pow(10, cnt) + remoteNum;
			}
			temp /= 10;
			cnt++;
		}

		min = Math.min(min, cnt + Math.abs(remoteNum - N));
*/		
		// 방법 4. 0번부터 MAX까지 누를 수 있는 모든 채널에서 +, - 로 이동
		for(int i=0;i<MAX;i++) {
			int cnt = canGo(i);
			if(cnt > 0) {	// 갈 수 있으면 +,-로 갈 수 있는 거리 측정
				min = Math.min(cnt + Math.abs(N - i), min);
			}
		}
		
		System.out.println(min);
	}

	private static int canGo(int i) {
		int cnt = 0;
		for(char c : (i+"").toCharArray()) {
			if(number[c-'0']) {
				return 0;
			}
			cnt++;
		}
		return cnt;
	}

	private static void initInput() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			N = Integer.parseInt(br.readLine());

			int M = Integer.parseInt(br.readLine());
			if (M > 0) {
				StringTokenizer str = new StringTokenizer(br.readLine(), " ");

				while (M-- > 0) {
					number[Integer.parseInt(str.nextToken())] = true;
				}
			}
		} catch (NumberFormatException | IOException e) {
		}

	}

}
