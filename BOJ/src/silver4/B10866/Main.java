package silver4.B10866;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static StringBuilder sb = new StringBuilder();
	static List<Integer> deque = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		while(N-->0) {
			StringTokenizer str = new StringTokenizer(br.readLine()," ");
			switch(str.nextToken()) {
			case "push_front":
				deque.add(0, Integer.parseInt(str.nextToken()));
				break;
			case "push_back":
				deque.add(Integer.parseInt(str.nextToken()));
				break;
			case "pop_front":
				sb.append(deque.isEmpty() ? -1 : deque.remove(0)).append("\n");
				break;
			case "pop_back":
				sb.append(deque.isEmpty() ? -1 : deque.remove(deque.size()-1)).append("\n");
				break;
			case "size":
				sb.append(deque.size()).append("\n");
				break;
			case "empty":
				sb.append(deque.isEmpty() ? 1 : 0).append("\n");
				break;
			case "front":
				sb.append(deque.isEmpty() ? -1 : deque.get(0)).append("\n");
				break;
			case "back":
				sb.append(deque.isEmpty() ? -1 : deque.get(deque.size()-1)).append("\n");
			}
		}
		
		System.out.println(sb);
	}

}
