package silver3.B1406;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {

	static class Editor {
		
		List<Character> list = new LinkedList<>();
		ListIterator<Character> iter = list.listIterator(list.size());

		Editor(String input) {
			for (char c : input.toCharArray()) {
				P(c);
			}
		}

		void P(char c) {
			iter.add(c);
		}

		void B() {
			if (iter.hasPrevious()) {
				iter.previous();
				iter.remove();
			}
		}

		void D() {
			if (iter.hasNext()) {
				iter.next();
			}
		}

		void L() {
			if (iter.hasPrevious()) {
				iter.previous();
			}
		}

		String print() {
			StringBuilder sb = new StringBuilder();
			for (char c : list) {
				sb.append(c);
			}
			return sb.toString();
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		Editor editor = new Editor(input);
		int M = Integer.parseInt(br.readLine());
		while(M-- > 0) {
			char[] temp = br.readLine().toCharArray();
			
			switch(temp[0]) {
			case 'P':
				editor.P(temp[2]);
				break;
			case 'B':
				editor.B();
				break;
			case 'D':
				editor.D();
				break;
			case 'L':
				editor.L();
				break;
			}
		}
		System.out.println(editor.print());

	}

}
