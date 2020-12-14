package B20309;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[Integer.parseInt(br.readLine())];
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(str.nextToken());
		}
		boolean flag = true;
		while (flag) {
			for (int i = 1; i < arr.length - 1; i++) {
				if (arr[i - 1] > arr[i + 1]) { // 왼쪽 > 오른쪽
					int temp = arr[i - 1];
					arr[i - 1] = arr[i + 1];
					arr[i + 1] = temp;
					flag |= true; // flag = true
				} else {
					flag &= false; // flag = false
				}
			}
		}

		flag = true;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] < arr[i]) {
				continue;
			} else {
				flag = false;
				break;
			}
		}

		System.out.println(flag ? "YES" : "NO");

	}

}
