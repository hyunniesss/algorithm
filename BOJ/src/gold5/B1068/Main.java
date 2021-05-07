package gold5.B1068;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
	static int N, root;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;

		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			tree.add(new ArrayList<>());
		}
		str = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) { // i가 자식
			int parent = Integer.parseInt(str.nextToken());
			if (parent == -1) {
				root = i;
			} else {
				tree.get(parent).add(i);
			}
		}

		int delete = Integer.parseInt(br.readLine());
		if (delete == root) {
			System.out.println(0);
			return;
		}
		tree.get(delete).clear();

		for (int i = 0; i < N; i++) {
			if (tree.get(i).contains(delete)) {
				boolean flag = tree.get(i).remove((Integer) delete);
			}
		}

		System.out.println(bfs(delete));

	}

	private static int bfs(int delete) {

		int cnt = 0;
		Queue<Integer> queue = new LinkedList<>();
		boolean[] check = new boolean[N];
		check[root] = true;
		queue.offer(root);
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			ArrayList<Integer> subT = tree.get(cur);
			if (subT.size() == 0) {
				cnt++;
				continue;
			}
			for (int i = 0; i < subT.size(); i++) {
				int next = subT.get(i);
				if (!check[next]) {
					check[next] = true;
					queue.offer(next);
				}
			}
		}

		return cnt;
	}

}
