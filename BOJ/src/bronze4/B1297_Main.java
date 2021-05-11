package bronze4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1297_Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(str.nextToken()); // 대각선
		int b = Integer.parseInt(str.nextToken()); // 높이
		int c = Integer.parseInt(str.nextToken()); // 너비
		double x = Math.sqrt((a * a) / (double) (b * b + c * c));
		System.out.println((int) (x * b) + " " + (int) (x * c));
	}
}
