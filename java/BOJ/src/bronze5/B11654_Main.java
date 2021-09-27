package bronze5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11654_Main {

	public static void main(String[] args) {
		try {
			System.out.println((int) (new BufferedReader(new InputStreamReader(System.in)).readLine().charAt(0)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}