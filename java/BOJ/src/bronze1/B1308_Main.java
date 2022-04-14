package bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

public class B1308_Main {
//	1. 4로 나뉘면 윤년, 100으로 나뉘면 평년, 400으로 나뉘면 윤년
	static int[] dates = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) throws IOException, ParseException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		int curYear = Integer.parseInt(str.nextToken());
		int curMonth = Integer.parseInt(str.nextToken());
		int curDay = Integer.parseInt(str.nextToken());

		str = new StringTokenizer(br.readLine(), " ");
		int targetYear = Integer.parseInt(str.nextToken());
		int targetMonth = Integer.parseInt(str.nextToken());
		int targetDay = Integer.parseInt(str.nextToken());
		int answer = 0;
		// 1000년 -> 일수로 환산
		int THOUSAND = 365000;
		for (int i = 0; i < 1000; i++) {
			if (isYoon(curYear + i)) {
				THOUSAND++;
			}
		}
		while (!(targetYear == curYear && targetMonth == curMonth && targetDay == curDay)) {
			curDay++;
			answer++;

			if (isYoon(curYear)) { // 윤년 2월 30일
				if (curMonth == 2) {
					if (curDay > (dates[2] + 1)) {
						curDay = 1;
						curMonth++; // 3월
					}
				} else {
					if (curDay > dates[curMonth]) {
						curDay = 1;
						curMonth++;
						if (curMonth > 12) {
							curMonth = 1;
							curYear++;
						}
					}
				}
			} else if (curDay > dates[curMonth]) {
				curDay = 1;
				curMonth++;
				if (curMonth > 12) {
					curMonth = 1;
					curYear++;
				}
			}
		}
		if (answer >= THOUSAND) {
			System.out.println("gg");
		} else {
			System.out.println("D-" + answer);
		}
	}

	private static boolean isYoon(int year) {
		return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
	}
}
