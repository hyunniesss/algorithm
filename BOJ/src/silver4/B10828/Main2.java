package silver4.B10828;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main2 {
	
	static int N;
	static StringBuilder sb = new StringBuilder();
	static Stack<Integer> st = new Stack<>();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer str = null;
		for(int n=0;n<N;n++) {
			str = new StringTokenizer(br.readLine()," ");
			String order = str.nextToken();
			sb.append(
					order.equals("push") ? st.add(Integer.parseInt(str.nextToken())) :
						order.equals("pop") ? (st.isEmpty() ? -1 : st.pop())+"\n" : 
							order.equals("size") ? st.size()+"\n" :
								order.equals("empty") ? (st.isEmpty() ? 1 : 0)+"\n" :
									order.equals("top") ? (st.isEmpty() ? -1 : st.peek())+"\n" : ""
					);
		}
		
		System.out.println(sb.toString().replaceAll("true", ""));
		
	}

}
