package silver4.B1002;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author hyunhee 
 * 터렛 : 두 원 사이의 거리공식 이용 
 * <입력> 첫째 줄에 테스트 케이스의 개수 T가 주어진다.각 테스트 케이스는 다음과 같이 이루어져 있다. 
 * 한 줄에 x1, y1, r1, x2, y2, r2가 주어진다. 
 * (x1, y1, x2, y2는 -10,000보다 크거나 같고, 10,000보다 작거나 같은 정수) 
 * (r1, r2는 10,000보다 작거나 같은 자연수)
 */

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {

			StringTokenizer str = new StringTokenizer(br.readLine(), " ");
			double[] a = new double[3];
			for (int i = 0; i < 3; i++) {
				a[i] = Double.parseDouble(str.nextToken());
			}
			double[] b = new double[3];
			for (int i = 0; i < 3; i++) {
				b[i] = Double.parseDouble(str.nextToken());
			}
			double plus = a[2] + b[2];
			double minus = Math.abs(a[2] - b[2]);
//			int dist = Math.abs(a[0]-b[0]) + Math.abs(a[1]-b[1]);
			double dist = Math.sqrt(Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
			if (a[0] == b[0] && a[1] == b[1]) { // 두 원의 중점이 같고
				if (a[2] == b[2]) { // 반지름이 같을 때
					System.out.println("-1");
				} else { // 반지름이 다를 때
					System.out.println("0");
				}
			} else if (dist < minus || plus < dist) { // 원이 다른 원 안에 있거나 다른 원 밖에 있을 때
				System.out.println("0");
			} else if (minus == dist || plus == dist) { // 원이 다른 원과 내접하거나 외접할 때
				System.out.println("1");
			} else if (minus < dist && dist < plus) { // 두 점에서 만날때
				System.out.println("2");
			}

		}

	}

}
