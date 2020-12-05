package silver5.B1158;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_timeout {
	
	static List<Integer> list = new ArrayList<>();
	static int N, K;
	static StringBuilder sb = new StringBuilder("<");
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(str.nextToken());
		K = Integer.parseInt(str.nextToken());
		
		int k = 1;
		int idx = 1;
		list.add(idx++);
		while(k<=K) {
			if(list.isEmpty()) {
				break;
			}
			if(k==K) {
				int temp = list.remove(list.size()-1);
				sb.append(temp).append(", ");
				k=0;
			}
			else {
				if(idx > N) {
					list.add(list.remove(0));
				} else {
					list.add(idx++);
				}
				k++;
			}
		}
		System.out.println(sb.substring(0, sb.length()-2)+">");
	}

}
