package CH14;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class C05DateMain {
	public static void main(String[] args) {
		//Date
		Date d1 = new Date();
		System.out.println(d1);
		System.out.println(d1.getYear()+1900);
		System.out.println(d1.getMonth()+1);
		System.out.println(d1.getDay());
		System.out.println(d1.getHours());
		System.out.println(d1.getMinutes());
		System.out.println(d1.getSeconds());
		System.out.println(d1.getTime());
		System.out.println("===========");
		//Calendar
		Calendar d2 = Calendar.getInstance();
		System.out.println(d2);
		System.out.println(d2.get(Calendar.YEAR));
		System.out.println(d2.get(Calendar.MONTH)+1);
		System.out.println(d2.get(Calendar.DAY_OF_MONTH));
		System.out.println(d2.get(Calendar.DAY_OF_WEEK));
		System.out.println(d2.get(Calendar.HOUR_OF_DAY));
		System.out.println(d2.get(Calendar.MINUTE));
		System.out.println(d2.get(Calendar.SECOND));
		
		//LocalDateTime
		LocalDateTime nowDateTime = LocalDateTime.now();
		int year = nowDateTime.getYear();
		int month = nowDateTime.getMonthValue();
		int day = nowDateTime.getDayOfMonth();
		int hour = nowDateTime.getHour();
		int minute = nowDateTime.getMinute();
		int second = nowDateTime.getSecond();
		DayOfWeek dayOfWeek = nowDateTime.getDayOfWeek();
		System.out.println("연 : " + year);
		System.out.println("월 : " + month);
		System.out.println("일 : " + day);
		System.out.println("시 : " + hour);
		System.out.println("분 : " + minute);
		System.out.println("초 : " + second);
		System.out.println("요일 : " + dayOfWeek);
		
	}
}
