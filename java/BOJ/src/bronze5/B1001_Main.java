package bronze5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1001_Main {

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer str = new StringTokenizer(br.readLine(), " ");
			System.out.println(Integer.parseInt(str.nextToken()) 
					- Integer.parseInt(str.nextToken()));
		} catch (Exception e) {

		}

	}

}
