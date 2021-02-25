package bronze2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B2161_Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		for(int n=1;n<=N;n++) {
			queue.offer(n);
		}
		
		StringBuilder sb = new StringBuilder();
		while(queue.size()>1) {
			sb.append(queue.poll()).append(" ");
			queue.offer(queue.poll());
		}
		sb.append(queue.poll());
		
		System.out.println(sb);
		
	}

}
