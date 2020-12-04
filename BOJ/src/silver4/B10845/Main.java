package silver4.B10845;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static List<Integer> queue = new ArrayList<>();
	static int N;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for(int n=0;n<N;n++) {
			StringTokenizer str = new StringTokenizer(br.readLine()," ");
			switch(str.nextToken()) {
			case "push":
				queue.add(Integer.parseInt(str.nextToken()));
				break;
			case "pop":
				sb.append(queue.isEmpty() ? -1 : queue.remove(0)).append("\n");
				break;
			case "size":
				sb.append(queue.size()+"\n");
				break;
			case "empty":
				sb.append(queue.isEmpty() ? 1 : 0).append("\n");
				break;
			case "front":
				sb.append(queue.isEmpty() ? -1 : queue.get(0)).append("\n");
				break;
			case "back":
				sb.append(queue.isEmpty() ? -1 : queue.get(queue.size()-1)).append("\n");
			}
		}
		
		System.out.println(sb);
		
	}

}
