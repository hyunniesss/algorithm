package silver1.B1991;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<ArrayList<Character>> al = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			al.add(new ArrayList<>());
		}

		for (int i = 0; i < N; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			int root = str.nextToken().charAt(0) - 'A';
			char left = str.nextToken().charAt(0);
			char right = str.nextToken().charAt(0);
			al.get(root).add(left);
			al.get(root).add(right);
		}

		preOrder(0);
		sb.append("\n");
		inOrder(0);
		sb.append("\n");
		postOrder(0);
		System.out.println(sb.toString());

	}

	private static void postOrder(int root) {
		if ((char) (root + 'A') == '.') {
			return;
		}
		ArrayList<Character> a = al.get(root);
		postOrder(a.get(0) - 'A');
		postOrder(a.get(1) - 'A');
		sb.append((char) (root + 'A') + "");
	}

	private static void inOrder(int root) {
		if ((char) (root + 'A') == '.') {
			return;
		}
		ArrayList<Character> a = al.get(root);
		inOrder(a.get(0) - 'A');
		sb.append((char) (root + 'A') + "");
		inOrder(a.get(1) - 'A');
	}

	private static void preOrder(int root) {
		if ((char) (root + 'A') == '.') {
			return;
		}
		sb.append((char) (root + 'A') + "");
		ArrayList<Character> a = al.get(root);
		preOrder(a.get(0) - 'A');
		preOrder(a.get(1) - 'A');
	}

}
