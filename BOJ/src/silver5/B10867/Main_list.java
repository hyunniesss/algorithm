package silver5.B10867;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_list {
	
	static List<Integer> input = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		StringTokenizer str = new StringTokenizer(br.readLine());
		while(str.hasMoreTokens()) {
			int x = Integer.parseInt(str.nextToken());
			if(input.contains(x)) {
				continue;
			}
			input.add(x);
		}
		
		Collections.sort(input);
		
		for(int i=0;i<input.size();i++) {
			sb.append(input.get(i)).append(" ");
		}
		
		System.out.println(sb);
	}

}
