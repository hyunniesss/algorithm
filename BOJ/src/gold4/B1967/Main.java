package gold4.B1967;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<ArrayList<Node>> al = new ArrayList<>();

	static class Node {
		int node;
		int price;

		public Node(int node, int price) {
			this.node = node;
			this.price = price;
		}

	}

	static int MAX = -1;
	static int maxIdx;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i <= N; i++) {
			al.add(new ArrayList<>());
		}
		check = new boolean[N + 1];

		for (int i = 1; i < N; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			int c = Integer.parseInt(str.nextToken());
			al.get(a).add(new Node(b, c));
			al.get(b).add(new Node(a, c));
		}

		check[1] = true;
		findOne(1, 0);
		Arrays.fill(check, false);
		check[maxIdx] = true;
		findOne(maxIdx, 0);

		System.out.println(MAX);

	}

	static boolean[] check;

	private static void findOne(int cur, int sum) {
		if (MAX < sum) {
			MAX = sum;
			maxIdx = cur;
		}

		ArrayList<Node> temp = al.get(cur);
		for (int i = 0; i < temp.size(); i++) {
			Node next = temp.get(i);
			if (!check[next.node]) {
				check[next.node] = true;
				findOne(next.node, sum + next.price);
				check[next.node] = false;
			}
		}
	}

}
