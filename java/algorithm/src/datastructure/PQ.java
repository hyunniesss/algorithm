package datastructure;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PQ {

	public static void main(String[] args) {

		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2 > 0 ? 1 : -1;
			}

		});

		pq.offer(2);
		pq.offer(1);

		System.out.println(Arrays.toString(pq.toArray()));

	}

}
