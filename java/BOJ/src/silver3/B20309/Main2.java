package silver3.B20309;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer str = new StringTokenizer(br.readLine()," ");
		boolean flag = true;
		for(int n=1;n<=N;n++) {
			if(Integer.parseInt(str.nextToken())%2 == n%2) {
				continue;
			} else {
				flag = false;
				break;
			}
		}
		
		System.out.println(flag ? "YES" : "NO");
	}

}
