package silver5.B11650;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author hyunhee
 * N ( 1 ≤ N ≤ 100,000 )
 * ( -100,000 ≤ xi, yi ≤ 100,000 )
 *
 */

public class Main1_runtime {

	static int N;
	static List<int[]> loc = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		while(N-->0) {
			StringTokenizer str = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(str.nextToken());
			int y = Integer.parseInt(str.nextToken());
			int index = 0;
			if(!loc.isEmpty()) {
				while(true) {
					int[] cur = loc.get(index);
					if(index >= loc.size())
						break;
					if(x>cur[0]) {
						index++;
						continue;
					}
					if(x==cur[0] && y>cur[0]) {
						index++;
						continue;
					}
					break;
				}
			}
			loc.add(index, new int[] {x,y});
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(!loc.isEmpty()) {
			int[] cur = loc.remove(0);
			sb.append(cur[0]).append(" ").append(cur[1]).append("\n");
		}
		
		System.out.println(sb);
		
		
	}
}
