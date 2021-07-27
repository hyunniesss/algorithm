package gold2.B12100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] MAP;
	static int[] arr = new int[5];

	public static void main(String[] args) {

		initMap();

		makeDirection(0);

		System.out.println(MAX);
	}

	private static void makeDirection(int cnt) {
		if (cnt == 5) {
			testDirection(MAP.clone());
			return;
		}
		for (int i = 0; i < 4; i++) {
			arr[cnt] = i;
			makeDirection(cnt + 1);
		}

	}

	static int MAX = -1;

	private static void testDirection(int[][] map) {
		for (int i = 0; i < 5; i++) {
			switch (arr[i]) {
			case 0:
				up(map);
				break;
			case 1:
				down(map);
				break;
			case 2:
				right(map);
				break;
			case 3:
				left(map);
				break;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				MAX = Math.max(map[i][j], MAX);
			}
		}

	}

	private static void print(int[][] map) {
		for (int[] m : map) {
			System.out.println(Arrays.toString(m));
		}
	}

	private static void initMap() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		try {
			N = Integer.parseInt(br.readLine());

			MAP = new int[N][N];
			for (int i = 0; i < N; i++) {
				str = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					MAP[i][j] = Integer.parseInt(str.nextToken());
				}
			}

		} catch (NumberFormatException | IOException e) {
		}
	}

	private static void up(int[][] map) {

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			stack.clear();
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					continue;
				}
				if (!stack.isEmpty()) {
					if (stack.peek() == map[i][j]) {
						stack.push(stack.pop() * 2);
						continue;
					}
				}
				stack.push(map[i][j]);
			}
			Arrays.fill(map[i], 0);
			for (int j = stack.size() - 1; j >= 0; j--) {
				map[i][j] = stack.pop();
			}
		}

	}

	private static void down(int[][] map) {

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			stack.clear();
			for (int j = N - 1; j >= 0; j--) {
				if (map[i][j] == 0) {
					continue;
				}
				if (!stack.isEmpty()) {
					if (stack.peek() == map[i][j]) {
						stack.push(stack.pop() * 2);
						continue;
					}
				}
				stack.push(map[i][j]);
			}
			Arrays.fill(map[i], 0);
			int j = N - 1 - stack.size();
			while (!stack.isEmpty()) {
				map[i][j++] = stack.pop();
			}
		}

	}

	private static void right(int[][] map) {

		Stack<Integer> stack = new Stack<>();
		for (int j = 0; j < N; j++) {
			stack.clear();
			for (int i = 0; i < N; i++) {
				if (map[i][j] == 0) {
					continue;
				}
				if (!stack.isEmpty()) {
					if (stack.peek() == map[i][j]) {
						stack.push(stack.pop() * 2);
						map[i][j] = 0;
						continue;
					}
				}
				stack.push(map[i][j]);
				map[i][j] = 0;
			}
			for (int i = stack.size() - 1; i >= 0; i--) {
				map[i][j] = stack.pop();
			}
		}

	}

	private static void left(int[][] map) {

		Stack<Integer> stack = new Stack<>();
		for (int j = 0; j < N; j++) {
			stack.clear();
			for (int i = N - 1; i >= 0; i--) {
				if (map[i][j] == 0) {
					continue;
				}
				if (!stack.isEmpty()) {
					if (stack.peek() == map[i][j]) {
						stack.push(stack.pop() * 2);
						map[i][j] = 0;
						continue;
					}
				}
				stack.push(map[i][j]);
				map[i][j] = 0;
			}

			int i = N - 1 - stack.size();
			while (!stack.isEmpty()) {
				map[i++][j] = stack.pop();
			}
		}

	}

}
