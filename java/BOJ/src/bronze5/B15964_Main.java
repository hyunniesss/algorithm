package bronze5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15964_Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		try {
			str = new StringTokenizer(br.readLine(), " ");
		} catch (IOException e) {
		}
		long A = Long.parseLong(str.nextToken());
		long B = Long.parseLong(str.nextToken());

		System.out.println((A + B) * (A - B));
	}

}
