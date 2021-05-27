package level4.동굴탐험;

import java.util.ArrayList;

public class Solution {

	public static void main(String[] args) {
		int n1 = 9;
		int[][] path1 = { { 0, 1 }, { 0, 3 }, { 0, 7 }, { 8, 1 }, { 3, 6 }, { 1, 2 }, { 4, 7 }, { 7, 5 } };
		int[][] order1 = { { 8, 5 }, { 6, 7 }, { 4, 1 } };

		System.out.println(solution(n1, path1, order1));
	}

	final static int MAX = 200001;
	static ArrayList<Integer>[] MAP;
	static ArrayList<Integer> al = new ArrayList<>();
	static int[][] orders;

	public static boolean solution(int n, int[][] path, int[][] order) {

		MAP = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			MAP[i] = new ArrayList<>();
		}
		int a, b;
		for (int i = 0; i < path.length; i++) {
			a = path[i][0];
			b = path[i][1];
			MAP[a].add(b);
			MAP[b].add(a);
		}
		orders = order;
		for (int i = 0; i < n; i++) { // 시작점
			al.clear();
			al.add(i);
			if (dfs(i, n)) {
				return true;
			}
		}

		return false;
	}

	private static boolean dfs(int pre, int N) {
		if (al.size() == N) {
			for (int i = 0; i < orders.length; i++) {
				if (al.indexOf(orders[i][0]) > al.indexOf(orders[i][1])) {
					return false;
				}
			}
			return true;
		}

		for (int i = 0; i < MAP[pre].size(); i++) {
			int next = MAP[pre].get(i);
			al.add(next);
			if (dfs(next, N)) {
				return true;
			}
			al.remove(al.size() - 1);
		}
		return false;
	}

}
