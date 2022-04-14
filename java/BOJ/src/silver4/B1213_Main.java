package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class B1213_Main {

	public static void main(String[] args) {

		int[] arr = new int[26];
		String s;
		try {
			s = new BufferedReader(new InputStreamReader(System.in)).readLine();
			for (char c : s.toCharArray()) {
				arr[c - 'A']++;
			}
		} catch (IOException e) {
		}

		StringBuilder front = new StringBuilder();
		int odd = 0; 
		String mid="";

		for (int i = 0; i < arr.length; i++) {
			while (arr[i] >= 2) {
				arr[i] -= 2;
				front.append((char) ('A' + i));
			}
			if(arr[i]>0) {
				odd++;
				mid = (char)('A'+i)+"";
			}
		}
		if(odd<=1) {
			System.out.println(front.toString()+mid+front.reverse().toString());
		}else {
			System.out.println("I'm Sorry Hansoo");
		}
//		String mid = "";
//		boolean flag = true;
//		for (int i = 0; i < arr.length; i++) {
//			if (arr[i] != 0) {
//				if (flag) {
//					mid = (char) ('A' + i) + "";
//					flag = !flag;
//				} else {
//					System.out.println("I'm Sorry Hansoo");
//					return;
//				}
//			}
//		}
//		System.out.println(front.toString()+mid+front.reverse().toString());

	}

}
