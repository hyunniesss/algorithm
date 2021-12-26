package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class B1302_Main {
	

	static class Book implements Comparable<Book> {
		String name;
		int cnt;

		public Book(String name, int cnt) {
			this.name = name;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Book o) {
			if(o.cnt == this.cnt) {
				return this.name.compareTo(o.name);	// 같으면 사전순
			}
			return Integer.compare(o.cnt, this.cnt);	// 내림차순 정렬
		}

	}

	public static void main(String[] args) {

		// 입력은 Book 클래스로
		// 입력받으면서 Map에 있으면 count+1 해서 배열에 저장
		// Map에 없으면 추가하고 1 담아서 배열에 저장
		initInput();

		for (int i = 0; i < N; i++) {
			books[i].cnt = map.getOrDefault(books[i].name, 0) + 1;
			map.put(books[i].name, books[i].cnt);
		}
		Arrays.sort(books);
		System.out.println(books[0].name);

	}

	static int N;
	static Book[] books;
	static Map<String, Integer> map = new HashMap<>();

	private static void initInput() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			N = Integer.parseInt(br.readLine());

			books = new Book[N];
			for (int i = 0; i < N; i++) {
				books[i] = new Book(br.readLine(), 0);
			}

		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}

}
