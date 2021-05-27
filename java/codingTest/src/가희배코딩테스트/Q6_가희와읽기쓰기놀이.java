package 가희배코딩테스트;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q6_가희와읽기쓰기놀이 {

	static int N, C; // 참가자 수
	static ArrayList<ArrayList<Integer>> cardList = new ArrayList<>(); // 각 참가자 별로 낸 카드
	static ArrayList<ArrayList<Card>> cards = new ArrayList<>();

	static class Card {
		String oper; // ADD , DEL
		String n;

		public Card(String oper, String n) {
			this.oper = oper;
			this.n = n;
		}
	}

	public static void main(String[] args) throws Exception {

		init();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i;
		}

		bw.write(sb.toString());
		bw.flush();

	}

	private static void init() throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		str = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(str.nextToken());
		C = Integer.parseInt(str.nextToken());
		cards = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			cardList.add(new ArrayList<>());
			str = new StringTokenizer(br.readLine(), " ");
			int count = Integer.parseInt(str.nextToken());
			while (count-- > 0) {
				cardList.get(i).add(Integer.parseInt(str.nextToken()) - 1);
			}
		}
		for (int c = 0; c < C; c++) {
			cards.add(new ArrayList<>());
			str = new StringTokenizer(br.readLine(), ",");
			StringTokenizer st = null;
			while (str.hasMoreTokens()) {
				st = new StringTokenizer(str.nextToken());
				Card card = new Card(st.nextToken(), st.nextToken());
				cards.get(c).add(card);
			}
		}
	}

}
