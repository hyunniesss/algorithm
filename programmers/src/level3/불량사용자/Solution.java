package level3.불량사용자;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
	
	HashMap<String, ArrayList<String>> hm = new HashMap<>();
	ArrayList<String> list = new ArrayList<>();
	final int N = 8;
	boolean[] check = new boolean[N];

	public int solution(String[] user_id, String[] banned_id) {

		for (int i = 0; i < banned_id.length; i++) {
			ArrayList<String> pref = hm.put(banned_id[i], new ArrayList<>());
		}
		
		System.out.println(Arrays.toString(hm.keySet().toArray()));

		for (int i = 0; i < banned_id.length; i++) {

			for (int j = 0; j < user_id.length; j++) {
				if (user_id[j].length() == banned_id[i].length()) {
					boolean flag = true;
					for (int k = 0; k < user_id[j].length(); k++) {
						if (banned_id[i].charAt(k) == '*') {
							continue;
						}
						if (banned_id[i].charAt(k) == user_id[j].charAt(k)) {
							continue;
						}
						flag = false;
						break;
					}
					if (flag) {
						ArrayList<String> temp = hm.get(banned_id[i]);
						temp.add(user_id[j]);
						hm.put(banned_id[i], temp);
					}

				}
			}
		}


		return answer;
	}

	int answer = 0;

	

}
