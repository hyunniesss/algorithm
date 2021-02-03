package silver4.B1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(str.nextToken());
		for (int n = 1; n <= N; n++) {
			list.add(n);
		}
		int M = Integer.parseInt(str.nextToken());
		str = new StringTokenizer(br.readLine(), " ");
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			int target = Integer.parseInt(str.nextToken());
			int idx = list.indexOf(target);
			int size = list.size();
			if (size - idx > idx) { // 왼쪽에 갯수가 더 적으므로 앞에꺼 빼서 뒤에 붙여
				for (int k = 0; k < idx; k++) {
					list.add(list.remove(0));
					cnt++;
				}
			} else {
				for (int k = size - 1; k >= idx; k--) { // 오른쪽에 갯수가 더 적으므로 뒤에꺼 빼서 앞에 붙여
					list.add(0, list.remove(list.size() - 1));
					cnt++;
				}
			}
			list.remove(0);
		}
		
		System.out.println(cnt);

	}

}
