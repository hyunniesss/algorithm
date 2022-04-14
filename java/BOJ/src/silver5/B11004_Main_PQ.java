package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B11004_Main_PQ {
	
	static PriorityQueue<Integer> arr = new PriorityQueue<>();
	static int K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;

		str = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(str.nextToken());
		K = Integer.parseInt(str.nextToken());

		str = new StringTokenizer(br.readLine(), " ");
		int next = -1;
		while (N-- > 0) {
			next = Integer.parseInt(str.nextToken());
			arr.offer(next);
		}
		while(K-- > 0) {
			next = arr.poll();
		}
		System.out.println(next);

	}

	

}
