package d4.S1251;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int[] parents;
	static int[] rank;

	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		long price;

		public Edge(int start, int end) {
			this.start = start;
			this.end = end;
			this.price = (long) (Math.pow(pos[start][0] - pos[end][0], 2) + Math.pow(pos[start][1] - pos[end][1], 2));
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.price, o.price);
		}

	}

	static Edge[] edges;
	static int V; // 섬의 개수
	static int[][] pos;
	static long result;
	static double E; // 환경부담세금

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			bw.write("#" + t + " ");

			V = Integer.parseInt(br.readLine());
			pos = new int[V][2];
			parents = new int[V];
			rank = new int[V];
			edges = new Edge[(V * (V - 1)) / 2];

			StringTokenizer str = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < V; i++) {
				pos[i][0] = Integer.parseInt(str.nextToken());
			}

			str = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < V; i++) {
				pos[i][1] = Integer.parseInt(str.nextToken());
			}

			E = Double.parseDouble(br.readLine());

			for (int i = 0, idx = 0; i < V - 1; i++) { // 간선배열 저장
				for (int j = i + 1; j < V; j++) {
					edges[idx] = new Edge(i, j);
					idx++;
				}
			}
			result = 0L;
			kruskal();
			bw.write(Math.round(result * E) + "");
			bw.newLine();
		}

		bw.flush();

	}

	private static void kruskal() {

		// 1. 부모노드 초기화
		for (int i = 0; i < V; i++) {
			makeSet(i);
		}

		// 2. 간선 배열 오름차순 정렬
		Arrays.sort(edges);

		// 3. 간선 가중치 작은 값부터 돌면서 V-1개 간선 고르기
		for (int i = 0, count = 0; i < edges.length; i++) {
			int px = findSet(edges[i].start);
			int py = findSet(edges[i].end);

			if (px == py) { // 같은 부모노드이면
				continue;
			}

			unionSet(px, py);
			result += edges[i].price;
			count++;
			if (count == V - 1) {
				break;
			}
		}

	}

	private static void unionSet(int x, int y) {

		int px = findSet(x);
		int py = findSet(y);
		if (rank[px] > rank[py]) {
			parents[py] = px;
		} else {
			parents[px] = py;
			if (rank[px] == rank[py]) {
				rank[py]++;
			}
		}

	}

	private static int findSet(int x) {
		if (parents[x] == x) {
			return x;
		}
		return findSet(parents[x]);
	}

	private static void makeSet(int x) {
		parents[x] = x;
	}

}
