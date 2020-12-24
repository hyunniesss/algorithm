package d1.S1936;

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		System.out.println(
				(A < B && !(A==1 && B==3)) ? "B" : "A");
		sc.close();
	}

}
