package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author hyunhee 
 * 한수 : 어떤 양의 정수 X의 각 자리가 등차수열을 이룬다
 *  Q. N보다 작거나 같은 한수의 개수를 출력
 */
public class B1065_Main {

	static int N, result;

	public static void main(String[] args) {
		initProcess();
		if (N < 100) {
			result = N;
		} else {
			result = 99;
			makeHansu();
		}
		System.out.println(result);

	}

	private static void makeHansu() {
		boolean flag;
		for (int i = 100; i <= N; i++) {
			flag = true;
			char[] temp = (i + "").toCharArray();
			int diff = (temp[0] - '0') - (temp[1] - '0');
			for (int j = 1; j < temp.length - 1; j++) {
				if (diff == ((temp[j] - '0') - (temp[j + 1] - '0'))) {
					continue;
				} else {
					flag = false;
					break;
				}
			}
			result = flag ? result + 1 : result;
		}

	}

	private static void initProcess() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			N = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

}
