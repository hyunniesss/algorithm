package level1.비밀지도;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		int n = 5;
		int[] arr1 = { 9, 20, 28, 18, 11 };
		int[] arr2 = { 30, 1, 21, 17, 28 };
		System.out.println(Arrays.toString(solution(n, arr1, arr2)));

	}

	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		for (int i = 0; i < n; i++) {
			StringBuilder bin = new StringBuilder();
			StringBuilder bina = new StringBuilder();
			int temp = arr1[i];
			while (temp > 0) {
				bin.insert(0,temp % 2);
				temp /= 2;
			}
			while(bin.length()<n) {
				bin.insert(0, "0");
			}
			temp = arr2[i];
			while(temp > 0) {
				bina.insert(0,temp%2);
				temp /=2;
			}
			while(bina.length()<n) {
				bina.insert(0, "0");
			}
			StringBuilder calc = new StringBuilder();
			for(int j=0;j<bin.length();j++) {
				calc.append(bina.charAt(j)=='0' && bin.charAt(j)=='0' ? " " : "#");
			}
			answer[i] = calc.toString();
			
		}
		return answer;
	}

}
