package silver3.B1406;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main2 {

	static int M;
	static List<Character> list = new LinkedList<>();
	static ListIterator<Character> iter = list.listIterator(list.size());
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		M = Integer.parseInt(br.readLine());
		for (char c : input.toCharArray()) {
			iter.add(c);
		}
		while (M-- > 0) {
			char[] temp = br.readLine().toCharArray();
			switch (temp[0]) {
			case 'L':
				if (iter.hasPrevious()) {
					iter.previous();
				}
				break;
			case 'D':
				if (iter.hasNext()) {
					iter.next();
				}
				break;
			case 'B':
				if (iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
				break;
			case 'P':
				iter.add(temp[2]);
				break;
			}
		}
		
		for(char c : list) {
			sb.append(c);
		}
		
		System.out.println(sb);

	}

}
