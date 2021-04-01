package 류호석배코딩테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q5 {

	static int N, C;

	static class Jewel {
		int r;
		int c;
		int price;

		public Jewel(int r, int c, int price) {
			this.r = r;
			this.c = c;
			this.price = price;
		}

	}

	static Jewel[] jewel;
	static int MAXVAL = -1;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(str.nextToken());
		C = Integer.parseInt(str.nextToken());

		jewel = new Jewel[N];
		List<Integer> maxR = new ArrayList<>();
		List<Integer> maxC = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(str.nextToken());
			int c = Integer.parseInt(str.nextToken());
			int price = Integer.parseInt(str.nextToken());
			jewel[i] = new Jewel(r, c, price);
			if (!maxR.contains(r)) {
				maxR.add(r);
			}
			if (!maxC.contains(c)) {
				maxC.add(c);
			}
		}

		Collections.sort(maxR);
		Collections.sort(maxC);

		for (int i = maxR.size() - 1; i >= 0; i--) {
			for (int j = maxC.size() - 1; j >= 0; j--) {
				if (test(maxR.get(i), maxC.get(j))) {
					break;
				}
			}
		}
		System.out.println(MAXVAL);

	}

	private static boolean test(int w, int h) {
		int maxPrice = 0;
		int c = 0;
		for (int i = 0; i < N; i++) {
			if (jewel[i].r <= w && jewel[i].c <= h) {
				maxPrice += jewel[i].price;
				c++;
				if (c > C) {
					return false;
				}
			}
		}
		MAXVAL = Math.max(MAXVAL, maxPrice);
		return true;
	}

}
