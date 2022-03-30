package GoodBye2021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class CutThemAll {
	
	public static void main(String[] args) {
		
		List<Long> lengths = new ArrayList<>();
		lengths.add(3L);
		lengths.add(5L);
		lengths.add(4L);
		lengths.add(3L);
		System.out.println(cutThemAll(lengths, 9));
		
	}
	
	private static String cutThemAll(List<Long> lengths, long minLength) {
		
		Collections.sort(lengths);
		for(int f=0;f<lengths.size();f++) {	// 시작점
			long sum = 0;
			for(int r=f;r<lengths.size();r++) {
				sum += lengths.get(r);
				if(sum > minLength) {
					break;
				}
				if(sum == minLength) {
					return "possible";
				}
			}
		}
		TreeSet<String> ts=new TreeSet<>();
		String[] aa = (String[]) ts.toArray();
		HashMap<String, String> map = new HashMap<>();
		
		return "impossible";
	}
	
	

}
