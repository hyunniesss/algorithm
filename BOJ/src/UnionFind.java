import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UnionFind {

	static int[] parentNode; // 부모노드를 담을 공간
	static boolean[][] map;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(str.nextToken()); // 1번노드부터 N번 노드까지
		int M = Integer.parseInt(str.nextToken());

		parentNode = new int[N + 1];
		for (int i = 1; i <= N; i++) { // 연결 전 자신의 부모 노드는 자신
			parentNode[i] = i;
		}

		map = new boolean[N + 1][N + 1]; // 간선의 정보를 담을 공간

		for (int m = 0; m < M; m++) {
			str = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			map[a][b] = true;
			map[b][a] = true;
		}

		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				if (map[i][j] && !findParent(i, j)) { // 두 노드가 연결되어 있고 부모노드가 다르다면
					unionParent(i, j);
					System.out.println(Arrays.toString(parentNode));
				}
			}
		}
	}

	private static void unionParent(int a, int b) {

		a = findParent(a);
		b = findParent(b);
		if (a < b) { // a가 b보다 작으면 a가 부모노드
			parentNode[b] = a;
		} else {
			parentNode[a] = b;
		}

	}

	private static boolean findParent(int a, int b) {

		return findParent(a) == findParent(b);
	}

	private static int findParent(int x) {
		if (parentNode[x] == x) { // 내 부모노드가 나자신이면
			return x;
		}
		return parentNode[x] = findParent(parentNode[x]); // 아니면 부모노드를 찾아서 리턴
	}

}
