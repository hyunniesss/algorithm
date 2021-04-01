package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B1927_Main {

	static List<Integer> heap = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		heap.add(0); // 시작할 0번째꺼 버림
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			if (input == 0) {
				sb.append(deleteHeap()).append("\n");
			} else {
				insertHeap(input);
			}
		}

		System.out.println(sb);

	}

	private static void insertHeap(int input) {

		heap.add(input); // 마지막 노드에 값 삽입하고 부모랑 확인하면서 최소값 최대한 루트로 올리기

		sortChildHeap();

	}

	private static void sortChildHeap() {
		int child = heap.get(heap.size() - 1);
		int childPos = heap.size() - 1;

		while (childPos > 1 && heap.get(childPos / 2) > child) { // 자식노드가 부모노드를 가지면서(childPos>1) 부모노드가 자식노드보다 값이 클 동안 할
																	// 것.
			// 이 안에 들어오면 자식노드가 부모노드보다 작다는 얘기니까 교환해야해
			heap.set(childPos, heap.get(childPos / 2));
			heap.set(childPos / 2, child);
			childPos /= 2;
		}

	}

	private static int deleteHeap() {

		if (heap.size() < 2) {
			return 0;
		}

		int min = heap.get(1);

		heap.set(1, heap.get(heap.size() - 1)); // 힙의 가장 마지막 값을 제일 앞으로 옮기고 비교하면서 최소힙 정렬할거야
		heap.remove(heap.size() - 1);
		sortParentHeap();
		return min;
	}

	private static void sortParentHeap() {

		int pos = 1;
		while (pos * 2 < heap.size()) { // 자식노드가 있는동안 자식노드랑 비교
			int minPos = pos * 2; // 왼쪽 자식노드
			int min = heap.get(minPos);

			if (minPos + 1 < heap.size() && min > heap.get(minPos + 1)) {// 오른쪽자식노드
				minPos++;
				min = heap.get(minPos);
			}

			// 부모노드랑 자식노드 중 최소값 비교해서 자식이 더 작으면 교환
			if (heap.get(pos) > min) {
				int temp = heap.get(pos);
				heap.set(pos, heap.get(minPos));
				heap.set(minPos, temp);
				pos = minPos;
			} else {
				break;
			}
		}

	}

}
