package silver2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2841_Main_Stack {

	static Stack<Integer>[] prets = new Stack[6];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(str.nextToken());
//		int P = Integer.parseInt(str.nextToken());
		str.nextToken();
		int answer = 0;

		for (int i = 0; i < 6; i++) {
			prets[i] = new Stack<Integer>();
		}

		for (int i = 0; i < N; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			int idx = Integer.parseInt(str.nextToken()) - 1;
			int pret = Integer.parseInt(str.nextToken()) - 1;
			while (!prets[idx].isEmpty() && (prets[idx].peek() > pret)) {
				prets[idx].pop();
				answer++;
			}
			if (prets[idx].isEmpty() || prets[idx].peek() < pret) {
				prets[idx].push(pret);
				answer++;
			}
		}

		System.out.println(answer);

	}

}
