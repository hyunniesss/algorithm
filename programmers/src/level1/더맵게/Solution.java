package level1.더맵게;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    List<Integer> arr = new ArrayList<>();
    
    public int solution(int[] scoville, int K) {
//        arr.add(0);
//		for (int i = 0; i < scoville.length; i++) {
//			arr.add(scoville[i]);
//		}
//		int count = 0;
//        minHeap();
//		while (arr.size() >= 3 && arr.get(1) < K) {
//			makeHeap(); // 2개 삭제하고 1개 추가하고
//            minHeap();
//			count++;
//		}
//
//		return arr.get(1) < K ? -1 : count;
    	
    	PriorityQueue<Integer> pq = new PriorityQueue<>();
    	for(int i=0;i<scoville.length;i++) {
    		pq.add(scoville[i]);
    	}
    	
    	int answer = 0;
    	
    	while(pq.size()>=2 && pq.peek()<K) {
    		int a = pq.poll();
    		int b = pq.poll();
    		pq.add(a+(b*2));
    		answer++;
    	}
    	
    	return pq.peek()>=K ? answer : -1;
    	
	}

	private void makeHeap() {
		int a = arr.remove(1);
		minHeap();
        int b = arr.remove(1);
		arr.add(a + (b * 2));
	}

	private void minHeap() {

		for (int i = (arr.size()-1) / 2; i > 0; i--) {
			minHeapify(i);
		}
        
	}

	private void minHeapify(int i) {

		int left = 2 * i;
		int right = 2 * i + 1;
		int smallest = -1;

		if (left <= arr.size() - 1 && arr.get(left) < arr.get(i)) {
			smallest = left;
		} else {
			smallest = i;
		}

		if (right <= arr.size() - 1 && arr.get(right) < arr.get(smallest)) {
			smallest = right;
		}

		if (smallest != i) {

			int temp = arr.get(smallest);
			arr.set(smallest, arr.get(i));
			arr.set(i, temp);

			minHeapify(smallest);
		}

	}
}