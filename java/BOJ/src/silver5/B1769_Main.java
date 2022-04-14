package silver5;

import java.util.Scanner;

public class B1769_Main {

	public static void main(String[] args) {
		String a = "";
		try (Scanner sc = new Scanner(System.in)) {
			a = sc.nextLine();
		}
		int temp = 0;
		int cnt = 0;
		while (a.length() > 1) {
			cnt++;
			for (int i = 0; i < a.length(); i++) {
				temp += (a.charAt(i) - '0');
			}
			a = String.valueOf(temp);
			temp = 0;
		}
		System.out.println(cnt);
		System.out.println(Integer.parseInt(a) % 3 == 0 ? "YES" : "NO");
	}

}
