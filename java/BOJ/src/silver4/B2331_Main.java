package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B2331_Main {

	static ArrayList<Long> al = new ArrayList<>();
	static int P;
	static long S;

	public static void main(String[] args) {

		initGame();

		while (!al.contains(S)) {
			al.add(S);
			long temp = 0;
			while (S > 0) {
				temp += Math.pow(S % 10, P);
				S /= 10;
			}
			S = temp;
		}
		
		int idx = al.indexOf(S);
		System.out.println(idx);

	}

	private static void initGame() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str;
		try {
			str = new StringTokenizer(br.readLine(), " ");
			S = Long.parseLong(str.nextToken());
			P = Integer.parseInt(str.nextToken());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
