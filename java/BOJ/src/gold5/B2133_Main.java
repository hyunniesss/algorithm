package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2133_Main {
	
	static int[] arr;
	
	public static void main(String[] args) {
		int N = 0;
		try {
			N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		} catch (NumberFormatException | IOException e) {
		}
		
		int pref = 1;
		int diff = 0;
		if(N%2==1) {
			System.out.println(0);
		} else if(N==0){
			System.out.println(1);
		} else {
			do {
				diff += pref;
				pref += 2*diff;
			}while((N-=2)!=0);
			System.out.println(pref);
		}
		
	}

}
