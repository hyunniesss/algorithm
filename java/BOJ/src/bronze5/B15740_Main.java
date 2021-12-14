package bronze5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class B15740_Main {

	public static void main(String[] args) {

		BigInteger A, B;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		try {
			str = new StringTokenizer(br.readLine(), " ");
		} catch (IOException e) {
		}

		A = new BigInteger(str.nextToken());
		B = new BigInteger(str.nextToken());
		System.out.println(A.add(B));
	}

}
