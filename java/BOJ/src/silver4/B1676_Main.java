package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1676_Main {
	
	// 입력 N 최대 500
	// N까지 5와 2의 개수 찾기
	
	public static void main(String[] args) {
		
		int N = -1;
		try {
			N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		} catch (NumberFormatException | IOException e) {
		}
		
		int two=0, five=0;
		while(N-- >0) {
			int temp = N+1;
			while(temp%2==0) {
				temp/=2;
				two++;
			}
			while(temp%5==0) {
				temp/=5;
				five++;
			}
		}
		System.out.println(Math.min(two, five));
		
		
	}

}
