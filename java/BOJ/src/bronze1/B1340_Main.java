package bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1340_Main {
	// 윤년은 그 해가 400으로 나누어 떨어지는 해 이거나, 4로 나누어 떨어지면서, 100으로 나누어 떨어지지 않는 해 일때
	static final String[] month = { "January", "February", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December" };
	static final int[] times = { 31 * 24 * 60, 28 * 24 * 60, 31 * 24 * 60, 30 * 24 * 60, 31 * 24 * 60, 30 * 24 * 60,
			31 * 24 * 60, 31 * 24 * 60, 30 * 24 * 60, 31 * 24 * 60, 30 * 24 * 60, 31 * 24 * 60 };
	static final int[] yoonTimes = { 31 * 24 * 60, 29 * 24 * 60, 31 * 24 * 60, 30 * 24 * 60, 31 * 24 * 60, 30 * 24 * 60,
			31 * 24 * 60, 31 * 24 * 60, 30 * 24 * 60, 31 * 24 * 60, 30 * 24 * 60, 31 * 24 * 60 };

	static String curMonth;

	public static void main(String[] args) {
		double wholeTime = 365 * 24 * 60;
		double lasttime = initInput();
		if (isYoon) {
			wholeTime += 24 * 60; // 하루 더 추가

			for (int i = 0; i < 12; i++) {
				if (curMonth.equals(month[i])) {
					break;
				}
				lasttime += yoonTimes[i];
			}
		} else {
			for (int i = 0; i < 12; i++) {
				if (curMonth.equals(month[i])) {
					break;
				}
				lasttime += times[i];
			}
		}

		System.out.println((lasttime / wholeTime) * 100);
		
//		Date date = new Date(System.currentTimeMillis());
//		SimpleDateFormat dateformat = new SimpleDateFormat("MM dd, YYYY HH:mm");
//		System.out.println(dateformat.format(date));
		
//		String s = "Jan 10, 1981 00:31";
// DateTimeFormatter.BASIC_ISO_DATE
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm");
//		LocalDateTime parseddateTime = LocalDateTime.parse(s, formatter);

//		System.out.println(dateTime.toString());
//		System.out.println(formatter.format(date));

	}

	static boolean isYoon;

	private static double initInput() {
		double lasttime = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str;
		try {
			str = new StringTokenizer(br.readLine(), " :,");
			curMonth = str.nextToken();
			lasttime = (Integer.parseInt(str.nextToken()) - 1) * 24 * 60;
			int year = Integer.parseInt(str.nextToken());
			isYoon = year % 400 == 0 || (year % 4 == 0 && year % 100 != 0); // 윤년인지
			lasttime += (Integer.parseInt(str.nextToken()) * 60 + Integer.parseInt(str.nextToken())); // 분단위로 저장
		} catch (IOException e) {
		}
		return lasttime;
	}

}
