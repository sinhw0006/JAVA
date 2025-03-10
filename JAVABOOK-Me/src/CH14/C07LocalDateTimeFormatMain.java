package CH14;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class C07LocalDateTimeFormatMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("YYYY/MM/DD 입력 : ");
		String ymd = scanner.next();

		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd/HH/mm/ss");

		LocalDateTime date = LocalDateTime.parse(ymd, inputFormatter);
		System.out.println("입력된 날짜 : " + date);

		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy년MM월dd일 HH시mm분ss초");

		System.out.println("변환된 날짜 : " + date.format(outputFormatter));
	}
}
