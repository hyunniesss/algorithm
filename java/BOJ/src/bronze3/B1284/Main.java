package bronze3.B1284;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) {

		initInput();
		while (!queue.isEmpty()) {
			int a = queue.poll();
			int answer = 0;
			while (a != 0) {
				int temp = a % 10;
				a /= 10;
				switch (temp) {
				case 0:
					answer += 5;
					break;
				case 1:
					answer += 3;
					break;
				default:
					answer += 4;
					break;
				}
			}
			System.out.println(answer + 1);
		}

	}

	private static void initInput() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		try {
			while (!"0".equals(input = br.readLine())) {
				queue.offer(Integer.parseInt(input));
			}
		} catch (Exception e) {

		}
	}

}