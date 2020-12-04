package silver3.B1406;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 * @author hyunhee 
 * L : 커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨) 
 * D : 커서를 오른쪽으로 한 칸 옮김(커서가 문장의 맨 뒤이면 무시됨) 
 * B : 커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨) 
 * 		삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임 
 * P $ : $라는 문자를 커서 왼쪽에 추가함
 */

public class Main_timeout {

	static List<Character> list = new ArrayList<Character>();
	static int M;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		for(char c : input.toCharArray()) {
			list.add(c);
		}
		M = Integer.parseInt(br.readLine());
		int cur = list.size();
		while(M-- > 0) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			switch(str.nextToken()) {
			case "L":
				cur = cur-1 >-1 ? cur-1 : cur;
				break;
			case "D":
				cur = cur+1 <=list.size() ? cur+1 : cur;
				break;
			case "B":
				if(cur>0) {
				list.remove(cur-1);
				cur--;
				}
				break;
			case "P":
				list.add(cur++, str.nextToken().charAt(0));
				break;
			}
		}
		
		for(int i=0;i<list.size();i++)
			sb.append(list.get(i));
		System.out.println(sb);
		
	}

}
