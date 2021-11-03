package silver5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2941_Main {

	static String[] arr = { "dz=", "c=", "c-", "d-", "lj", "nj", "s=", "z=" };

	public static void main(String[] args) {
		String input = initProcess();
		for (String a : arr) {
			input = input.replaceAll(a, "p");
		}
		System.out.println(input.length());
	}

	private static String initProcess() {
		try {
			return new BufferedReader(new InputStreamReader(System.in)).readLine();
		} catch (Exception e) {
		}
		return null;
	}

}
