package bronze5;

import java.text.SimpleDateFormat;
import java.util.Date;

public class B10699_Main {
	
	public static void main(String[] args) {
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateformat = new SimpleDateFormat("YYYY-MM-dd");
		System.out.println(dateformat.format(date));
	}

}
