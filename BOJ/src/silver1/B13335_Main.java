package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B13335_Main {

	static int N, W, L;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(str.nextToken()); // 트럭 수
		W = Integer.parseInt(str.nextToken()); // 다리 길이
		L = Integer.parseInt(str.nextToken()); // 다리 하중

		int[] arr = new int[N];
		str = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(str.nextToken());
		}
		int[] bridge = new int[W];

		System.out.println(move(bridge, arr));
	}

	private static int move(int[] bridge, int[] arr) {

		int answer = 0, idx = 0, weight = 0;

		while (idx < N) {
			int reach = bridge[W - 1];
//			이동
			for (int i = W - 1; i > 0; i--) {
				bridge[i] = bridge[i - 1];
			}
			bridge[0] = 0;
//			도착한 트럭이 존재하면
			if (reach > 0) {
				weight -= reach;
			}
//			다리위에 트럭을 올릴 수 있으면
			if (idx < N && weight + arr[idx] <= L) {
				weight += arr[idx];
				bridge[0] = arr[idx];
				idx++;
			}
			answer++;
		}

		return answer + W;
	}

}
