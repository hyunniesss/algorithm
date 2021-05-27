import java.util.ArrayList;
import java.util.Stack;

// 강한 연결요소
public class SCC {

	public static void main(String[] args) {

		for (int i = 0; i < MAX; i++) {
			a[i] = new ArrayList<>();
		}

		int v = 11;
		a[1].add(2);
		a[2].add(3);
		a[3].add(1);
		a[4].add(2);
		a[4].add(5);
		a[5].add(7);
		a[6].add(5);
		a[7].add(6);
		a[8].add(5);
		a[8].add(9);
		a[9].add(10);
		a[10].add(11);
		a[11].add(3);
		a[11].add(8);

		for (int i = 1; i <= v; i++) {
			if (d[i] == 0) {
				dfs(i);
			}
		}
		System.out.println("SCC의 개수 : " + SCC.size());
		for (int i = 0; i < SCC.size(); i++) {
			System.out.print(i + 1 + "번째 SCC : ");
			for (int j = 0; j < SCC.get(i).size(); j++) {
				System.out.print(SCC.get(i).get(j) + "\t");
			}
			System.out.println();
		}
	}

	static final int MAX = 10001;
	static int id;
	static int[] d = new int[MAX];
	static boolean[] finished = new boolean[MAX];
	static ArrayList<Integer>[] a = new ArrayList[MAX];
	static ArrayList<ArrayList<Integer>> SCC = new ArrayList<>();
	static Stack<Integer> stack = new Stack<>();

	static int dfs(int x) {
		d[x] = ++id;
		stack.push(x);

		int parent = d[x];
		for (int i = 0; i < a[x].size(); i++) {
			int y = a[x].get(i);
			if (d[y] == 0) {
				parent = Math.min(parent, dfs(y));
			} else if (!finished[y]) {
				parent = Math.min(parent, d[y]);
			}
		}

		if (parent == d[x]) {
			ArrayList<Integer> scc = new ArrayList<>();
			while (true) {
				int t = stack.pop();
				scc.add(t);
				finished[t] = true;
				if (t == x) {
					break;
				}
			}
			SCC.add(scc);
		}

		return parent;
	}
}
