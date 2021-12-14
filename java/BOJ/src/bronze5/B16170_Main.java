package bronze5;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class B16170_Main {
	
	public static void main(String[] args) {
		Instant nowKst = Instant.now();
		ZoneId utc = ZoneId.of("UTC");
		ZonedDateTime nowUtc = ZonedDateTime.ofInstant(nowKst, utc);
		System.out.println(nowUtc.getYear()+"\n"+nowUtc.getMonthValue()+"\n"+nowUtc.getDayOfMonth());
	}

}
