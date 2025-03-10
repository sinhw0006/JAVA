package CH14;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class C06SimpleDateFormatMain {
	public static void main(String[] args) throws ParseException {
		Scanner scanner = new Scanner(System.in);
		System.out.print("YYYY/MM/DD 입력 : ");
		String ymd = scanner.next();
		
		SimpleDateFormat fmtin = new SimpleDateFormat("yyyy/MM/dd/hh/mm/ss");
		System.out.println(ymd);
		Date date = fmtin.parse(ymd);
		System.out.println(date);
		SimpleDateFormat fmout = new SimpleDateFormat("yyyy~MM~dd~hh~mm~ss");
		System.out.println(fmout.format(date));
		}
}
