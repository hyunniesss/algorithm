package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TopologySort {

	static ArrayList<Integer>[] al;
	static int N;
	static int[] inDegree;

	public static void main(String[] args) {

		N = 7;
		al = new ArrayList[N + 1];
		inDegree = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			al[i] = new ArrayList<>();
		}
		al[1].add(2);
		++inDegree[2];
		al[1].add(5);
		++inDegree[5];
		al[2].add(3);
		++inDegree[3];
		al[5].add(6);
		++inDegree[6];
		al[3].add(4);
		++inDegree[4];
		al[4].add(6);
		++inDegree[6];
		al[6].add(7);
		++inDegree[7];

		int[] result = topologySort();
		System.out.println(result == null ? "" : Arrays.toString(result));
	}

	private static int[] topologySort() {
		int[] result = new int[N];
		Queue<Integer> queue = new LinkedList<>();
		int cnt = 0;
//		1. 진입차수 0인 정점이 시작정점
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) {
				queue.offer(i);
			}
		}

//		2. 큐에서 정점 하나씩 빼면서 간선 제거 -> 진입차수가 0인 정점 큐에 담기
		for (int i = 0; i < N; i++) {
			if (queue.isEmpty()) {

				return null;
			}
			int x = queue.poll();
			for (int j = 0; j < al[x].size(); j++) {
				int y = al[x].get(j);
				if (--inDegree[y] == 0) {
					queue.offer(y);
				}
			}
			result[i] = x;
		}

		return result;

	}

}
