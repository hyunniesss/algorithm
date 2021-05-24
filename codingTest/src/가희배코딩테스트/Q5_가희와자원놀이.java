package 가희배코딩테스트;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q5_가희와자원놀이 {

	static HashMap<Long, Integer> hm = new HashMap<>(); // 카드번호, 사람이름

	static class Card {
		int id;
		String oper;
		long n;

		public Card(int id, String oper, long n) {
			this.id = id;
			this.oper = oper;
			this.n = n;
		}

	}

	static HashMap<Integer, ArrayList<Card>> person = new HashMap<>();
	static ArrayList<Card> cardList = new ArrayList<>();
	static int N, T;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(str.nextToken());
		T = Integer.parseInt(str.nextToken());
		int[] turn = new int[T];

		str = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < T; i++) {
			turn[i] = Integer.parseInt(str.nextToken());
		}
		for (int i = 0; i < T; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			int id = Integer.parseInt(str.nextToken());
			String oper = str.nextToken();
			int n;
			if ("next".equals(oper)) {
				n = 0;
			} else {
				n = Integer.parseInt(str.nextToken());
			}
			cardList.add(new Card(id, oper, n));
		}

		for (int i = 0; i < T; i++) {
			Card card = null;
			if (person.get(turn[i]) == null || person.get(turn[i]).size() == 0) {
				card = cardList.remove(0);
			} else {
				card = person.get(turn[i]).remove(0);
			}
			sb.append(card.id).append("\n");
			switch (card.oper) {
			case "acquire":
				acquire(card, turn[i]);
				break;
			case "release":
				release(card.n);
				break;
			}
		}

		bw.write(sb.toString());
		bw.flush();

	}

	private static boolean acquire(Card c, int who) {
		if (hm.containsKey(c.n)) { // 누군가 가지고 있으면 tobeContinued;
			if (person.get(who) == null) {
				person.put(who, new ArrayList<>());
			}
			person.get(who).add(c);
			return false;
		}
		hm.put(c.n, who);
		return true;
	}

	private static void release(long n) {
		hm.remove(n);
	}

}
