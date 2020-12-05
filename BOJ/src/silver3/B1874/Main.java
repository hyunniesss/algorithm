package silver3.B1874;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	static Stack<Integer> stack = new Stack<>();
	static int[] arr;
	static int N;
	static StringBuilder sb = new StringBuilder("+\n");
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for(int n=0;n<N;n++) {
			arr[n] = Integer.parseInt(br.readLine());
		} // end input
		int input = 1;
		stack.add(input++);
		for(int n=0;n<N;n++) {
			boolean flag = true;
			while(stack.isEmpty() || (stack.peek()!=arr[n] && flag) ) {
				stack.add(input++);
				sb.append("+\n");
				if(input > N+1) {
					flag = false;
				}
			}
			if(flag) {
				stack.pop();
				sb.append("-\n");
			} else {
				sb = new StringBuilder("NO");
				break;
			}
		}
		
		System.out.println(sb);
		
	}

}
