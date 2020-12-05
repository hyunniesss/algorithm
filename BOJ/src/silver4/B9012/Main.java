package silver4.B9012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	static Stack<Character> stack = new Stack<>();
	static int N;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		while(N-- > 0) {
			String input = br.readLine();
			stack.clear();
			for(char c : input.toCharArray()) {
				if(stack.isEmpty() || c == '(') {
					stack.add(c);
				}
				else {
					if(stack.peek()=='(') {
						stack.pop();
					}
					else {
						stack.add(c);
					}
				}
			}
			if(stack.isEmpty()) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
		}
		
		System.out.println(sb);
		
	}

}
