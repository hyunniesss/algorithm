package bronze5.B10757;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		StringBuilder a = new StringBuilder(str.nextToken());
		StringBuilder b = new StringBuilder(str.nextToken());
		StringBuilder c = new StringBuilder();

		a.reverse();
		b.reverse();

		int min = Math.min(a.length(), b.length());
		int d;
		boolean temp = false;
		for (int i = 0; i < min; i++) {
			d = (a.charAt(i) - '0') + (b.charAt(i) - '0');
			if (temp) {
				d++;
			}
			if (d >= 10) {
				temp = true;
			} else {
				temp = false;
			}
			c.append(d % 10);
		}
		
		for(int i=min;i<a.length();i++) {
			d = (a.charAt(i)-'0') + (temp ? 1 : 0);
			c.append(d%10);
			if(d>=10) {
				temp = true;
			} else {
				temp = false;
			}
		}
		
		for(int i=min;i<b.length();i++) {
			d = (b.charAt(i)-'0') + (temp ? 1 : 0);
			c.append(d%10);
			if(d>=10) {
				temp = true;
			} else {
				temp = false;
			}
		}
		
		if(temp) {
			c.append(1);
		}
		
		System.out.println(c.reverse().toString());

	}

}
