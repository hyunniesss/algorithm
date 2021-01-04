package B1230;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] before = br.readLine().toCharArray();
		List<Character> beforeList = new ArrayList<>();
		for (int i = 0; i < before.length; i++) {
			beforeList.add(before[i]);
		}
		char[] after = br.readLine().toCharArray();
		int j = 0;
		int answer = 0;
		for (int i = 0; i < before.length; i++) {
			boolean change = false;
			if (before[i] == ' ') {
				continue;
			}
			for (; j < after.length; j++) {
				if (before[i] == after[j]) {
					if (!change) {
						j++;
						break;
					} else {
						answer++;
						j++;
						break;
					}
				} else {
					change = true;
					beforeList.add(j, after[j]);
				}
			}
		}
//		System.out.println(Arrays.toString(beforeList.toArray()));
		System.out.println(beforeList.size() == after.length ? answer : answer==0 ? -1 : answer + 1);

	}

}
