package bronze5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B14928_Main {

	static char[] input;
	static final int MOD = 20000303;

	public static void main(String[] args) {

//		try {
//			BigInteger N = new BigInteger(new BufferedReader(new InputStreamReader(System.in)).readLine());
//			System.out.println(N.mod(new BigInteger("20000303")));
//		} catch (IOException e) {
//		}

		initInput();
		int answer = 0;
		for (int i = 0; i < input.length; i++) {
//			answer += ((input[i]-'0')*Math.pow(10,i))%MOD;
			answer = ((answer * 10) % MOD + input[i]-'0') % MOD;
		}
		System.out.println(answer%MOD);
	}

	private static void initInput() {
		input = null;
		try {
			input = new BufferedReader(new InputStreamReader(System.in)).readLine().toCharArray();
		} catch (IOException e) {
		}
	}

}
