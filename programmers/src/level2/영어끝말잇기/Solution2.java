package level2.영어끝말잇기;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution2 {
	
	
	public static void main(String[] args) {
		int n =3;
		String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};	
		System.out.println(Arrays.toString(solution(n, words)));
		n =5;
		words = new String[]{
				"hello", "observe", "effect", "take", "either", "recognize", "encourage",
				"ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"
				};	
		System.out.println(Arrays.toString(solution(n, words)));
		n = 2;
		words = new String[] {
				"hello", "one", "even","never","now","world","draw"
		};
		System.out.println(Arrays.toString(solution(n, words)));
	}
	
	
	private static int[] solution(int n, String[] words) {
		int[] count = new int[n];
		Set<String> set = new HashSet<>();
		
		int idx = 0, i =0;
		count[idx++]++;
		set.add(words[0]);
		char pre = words[0].charAt(words[0].length()-1);
		for(i=1;i<words.length;i++) {
			count[idx++]++;
			set.add(words[i]);
			if(pre!=words[i].charAt(0) || set.size()!=(i+1)) {
				return new int[] { idx, count[idx-1] }; 
			} else {
				if(idx >= n) {
					idx = 0;
				}
				pre = words[i].charAt(words[i].length()-1);
			}
		}

        return new int[] {0,0};
    }

}
