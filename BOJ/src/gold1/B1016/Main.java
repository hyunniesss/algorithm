package gold1.B1016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		long min = Long.parseLong(str.nextToken());
		long max = Long.parseLong(str.nextToken());
		int answer = (int) (max - min + 1);
		boolean[] check = new boolean[(int) (max - min + 1)];
		for(int i=2;i<=(int)(Math.sqrt(max));i++) {
			boolean flag = true;
			for(int j=0;j<(int) (max - min + 1);j++) {
				
			}
			if(flag) {
				break;
			}
		}

		System.out.println(answer);
	}

}
