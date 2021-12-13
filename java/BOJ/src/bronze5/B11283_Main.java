package bronze5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11283_Main {
    public static void main(String[] args) {
        // System.out.println((int)('가'));
    	try {
			System.out.println((int)(new BufferedReader(new InputStreamReader(System.in)).readLine().charAt(0))-44031);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}