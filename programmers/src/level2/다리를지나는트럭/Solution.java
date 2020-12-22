package level2.다리를지나는트럭;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	public static void main(String[] args) {

		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = { 7, 4, 5, 6 };
		System.out.println(solution(bridge_length, weight, truck_weights));
		bridge_length = 100;
		weight = 100;
		truck_weights = new int[] { 10 };
		System.out.println(solution(bridge_length, weight, truck_weights));
		bridge_length = 100;
		weight = 100;
		truck_weights = new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };
		System.out.println(solution(bridge_length, weight, truck_weights));

	}

//	public static int solution(int bridge_length, int weight, int[] truck_weights) {
//		int[] enter = new int[truck_weights.length];
//		boolean[] pass = new boolean[truck_weights.length];
//		int cnt = 1;
//		for (int i = 0; i < truck_weights.length; i++, cnt++) {
//			if (weight - truck_weights[i] >= 0) {
//				weight -= truck_weights[i];
//				enter[i] = cnt;
//			} else {
//				i--;
//			}
//			for (int j = 0; j < i; j++) {
//				if (!pass[j] && cnt - enter[j] == bridge_length) {
//					weight += truck_weights[j];
//					pass[j] = true;
//				}
//			}
//		}
//
//		return enter[enter.length-1]+bridge_length;
//	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		Queue<Integer> trucks = new LinkedList<>();
		Queue<int[]> roads = new LinkedList<>();
		for (int tw : truck_weights) {
			trucks.offer(tw);
		}
		int cnt = 0;
		while (!trucks.isEmpty()) {
			cnt++;
//			System.out.println("CNT : "+cnt);
//			System.out.println(Arrays.toString(trucks.toArray()));
			if (roads.size()>0 && cnt - roads.peek()[1] == bridge_length) {
				weight += roads.poll()[0];
			}
			if (weight - trucks.peek() >= 0) {
				weight -= trucks.peek();
				roads.offer(new int[] { trucks.poll(), cnt });
			}
//			Object[] arr = roads.toArray();
//			System.out.println(Arrays.toString(arr));
		}
		int[] last = {};
		while(!roads.isEmpty()) {
			last = roads.poll();
		}
		
		return bridge_length + last[1];
	}

}
