package silver4.B2108;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * @author hyunhee 첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다. 둘째 줄에는 중앙값을
 *         출력한다. 셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다. // map 넷째
 *         줄에는 범위를 출력한다.
 */

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int sum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}

		// 1. 산술 평균
		int avg = Math.round(sum / (float) N);
		bw.write(avg + "\n");

		// 2. 중앙값
		Arrays.sort(arr);
		bw.write(arr[N / 2] + "\n");

		// 3. 최빈값
		int max = -1;
		Set<Integer> ts = new TreeSet<>();
		for (int i = 0; i < N; i++) {
			if (max <= map.get(arr[i])) {
				if (max < map.get(arr[i])) {
					ts.clear();
				}
				ts.add(arr[i]);
				max = map.get(arr[i]);
			}
		}
		if (ts.size() > 1) {
			bw.write(ts.toArray()[1] + "\n");
		} else {
			bw.write(ts.toArray()[0] + "\n");
		}

		// 4. 범위
		bw.write((arr[N - 1] - arr[0]) + "\n");

		bw.flush();
	}

}
