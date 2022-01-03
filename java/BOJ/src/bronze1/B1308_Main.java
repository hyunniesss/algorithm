package bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class B1308_Main {
//	1. 4로 나뉘면 윤년, 100으로 나뉘면 평년, 400으로 나뉘면 윤년
	public static void main(String[] args) throws IOException, ParseException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 오늘날짜
		String source = br.readLine().replaceAll(" ", "/");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date now = sdf.parse(source);
		source = br.readLine().replaceAll(" ", "/");
		Date dDay = sdf.parse(source);

		long diff = dDay.getTime() - now.getTime();
		TimeUnit time = TimeUnit.DAYS;
		long answer = time.convert(diff, TimeUnit.MILLISECONDS);
		if (answer < 365242) { // 천년은 date로
			System.out.println("D-" + answer);
		} else {
			System.out.println("gg");
		}

	}

}
