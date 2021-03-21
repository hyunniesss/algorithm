package line202103;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q4 {

	public static void main(String[] args) {

	}

	class Node {
		String name;
		int parent;

		public Node(String name, int parent) {
			super();
			this.name = name;
			this.parent = parent;
		}

	}

	public String[] solution(String[] data, String word) {

		Node[] tree = new Node[data.length + 1];
		int[] pi = new int[data.length + 1];
		boolean[] isLeaf = new boolean[data.length + 1];

		for (int i = 0; i < data.length; i++) {
			StringTokenizer str = new StringTokenizer(data[i], " ");
			int me = Integer.parseInt(str.nextToken());
			String name = str.nextToken();
			int parent = Integer.parseInt(str.nextToken());

			tree[me] = new Node(name, parent);
			pi[me] = parent;
			isLeaf[parent] = true;
		}

		List<Node> list = new ArrayList<>();

		// 검색..
		for (int i = 1; i < isLeaf.length; i++) {
			if (!isLeaf[i]) { // 검색할 수 있어
				if ((tree[i].name).contains(word)) { // 단어를 포함하면 index우선 저장
					list.add(tree[i]);
				}
			}
		}

		if (list.size() == 0) {
			return new String[] { "Your search for (" + word + ") didn't return any results" };
		}

		String[] result = null;
		// 검색한 애들이 2개 이상이면
		if (list.size() > 1) {
			
			

		} else {
			Node cur = list.get(0);
			String answer = "";
			while (cur.parent > 0) {
				answer = "/" + cur.name + answer;
				cur = tree[cur.parent];
			}

			result = new String[] { answer };
		}
		return result;
	}

}
