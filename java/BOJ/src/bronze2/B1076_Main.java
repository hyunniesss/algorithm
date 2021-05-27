package bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class B1076_Main {

	static Map<String, Integer> map;

	static String[] colors = { "black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey",
			"white" };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long result = 0L;
//		result = findNum(br.readLine(), result);
//		result = findNum(br.readLine(), result);
//		result = makeNum(br.readLine(), result);

		String answer = (map.get(br.readLine()) * 10 + map.get(br.readLine()) * (int)Math.pow(10, map.get(br.readLine())))
				+ "";

		System.out.println(result);

	}

	private static long makeNum(String color, long result) {
		for (int i = 0; i < 10; i++) {
			if (colors[i].equals(color)) {
				return result *= Math.pow(10, i);
			}
		}

		return result;
	}

	private static long findNum(String color, long result) {
		for (int i = 0; i < 10; i++) {
			if (colors[i].equals(color)) {
				return result = result * 10 + i;
			}
		}
		return result;
	}

}
