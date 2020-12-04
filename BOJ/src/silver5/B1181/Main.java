package silver5.B1181;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
	
	static TreeSet<String>[] ts = new TreeSet[51];
	static int N;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		for(int i=0;i<51;i++) {
			ts[i] = new TreeSet<>();
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		while(N-- > 0) {
			String input = br.readLine();
			ts[input.length()].add(input);
		}
		
		for(int i=0;i<51;i++) {
			while(!ts[i].isEmpty()) {
				sb.append(ts[i].pollFirst()).append("\n");
			}
		}
		
		System.out.println(sb);
	}

}
