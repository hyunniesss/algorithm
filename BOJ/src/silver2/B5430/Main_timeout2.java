package silver2.B5430;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_timeout2 {

	static List<Integer> list = new ArrayList<>();
	static int T, N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			list.clear();
			char[] punc = br.readLine().toCharArray();
			br.readLine();
			StringTokenizer str = new StringTokenizer(br.readLine(),"[,]");
			while(str.hasMoreTokens()) {
				list.add(Integer.parseInt(str.nextToken()));
			}
			int idx = 0;
			boolean flag = true;
			for(char c : punc) {
				if(list.size()==0) {
					sb.append("error\n");
					flag = false;
					break;
				}
				switch(c) {
				case 'R':
					idx = idx == 0 ? list.size()-1 : 0 ;
					break;
				case 'D':
					list.remove(idx);
					idx = idx == 0 ? 0 : idx-1;
					break;
				}
			}
			if(flag) {
				sb.append("[");
				if(idx==0) {
					for(int li : list) {
						sb.append(li+",");
					}
				} else {
					for(;idx>=0;idx--) {
						sb.append(list.get(idx)+",");
					}
				}
				sb = new StringBuilder(sb.substring(0, sb.length()-1));
				sb.append("]\n");
			}
		}
		
		System.out.println(sb);

	}

}
