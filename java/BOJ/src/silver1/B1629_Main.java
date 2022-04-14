package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class B1629_Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		BigInteger a = new BigInteger(str.nextToken());
		int b = Integer.parseInt(str.nextToken());
		BigInteger c = new BigInteger(str.nextToken());
//		a.mod(c).pow(b).mod(c);
		System.out.println((a.mod(c)).pow(b).mod(c));
	}

}
