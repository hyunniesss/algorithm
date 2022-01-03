package GoodBye2021;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class B {

	static final BigInteger MUL = new BigInteger("2");
	static final BigInteger THREE = new BigInteger("3");
	static final String POSITIVE = "TAK", NEGATIVE = "NIE";

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			BigInteger N = new BigInteger(br.readLine());
			int a = 1;
			while (true) {
				BigInteger modulus = new BigInteger(String.valueOf(a));
				if (N.mod(modulus) == BigInteger.ZERO) {
					BigInteger b = N.divide(modulus);
					if (modulus.compareTo(b) > 0) {
						sb.append(NEGATIVE).append("\n");
						break;
					}
					BigInteger round = (b.multiply(MUL)).add(modulus.multiply(MUL));
					if (round.mod(THREE) == BigInteger.ZERO) { // 3으로 나뉘면
						sb.append(POSITIVE).append("\n");
						break;
					}
				}

				a++;
			}
		}
		bw.write(sb.toString());
		bw.flush();
	}

}
