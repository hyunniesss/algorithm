package silver5;

import java.math.BigInteger;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10757_Main {
	
	static BigInteger A, B;
	
	public static void main(String[] args) {
		
		// 입력
		try {
		StringTokenizer str = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		A = new BigInteger(str.nextToken());
		B = new BigInteger(str.nextToken());
		} catch(Exception e) {}
		
		// 로직
		System.out.println(A.add(B));
	}

}
