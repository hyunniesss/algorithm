package bronze5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1000_Main {

	public static void main(String[] args) {
		int answer = 0;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			StringTokenizer str = new StringTokenizer(br.readLine(), " ");
			answer = Integer.parseInt(str.nextToken()) + Integer.parseInt(str.nextToken());
		} catch (Exception e) {
		}
		System.out.println(answer);
	}

}
