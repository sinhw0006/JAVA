package CH31;

import java.util.Scanner;

import org.openqa.selenium.bidi.script.Message;

interface Printer{
//	void print(String message);
//	String print(String message);
	String print();
}

public class C02Lamda {
	public static void main(String[] args) {
		//01
//		Printer printer = (message)->{System.out.println(message);};
//		printer.print("Hello World!");
		//02
//		Printer printer = (message)->{return message+"_HelloWorld";};
//		String returnValue = printer.print("TEST");
//		System.out.println(returnValue);
		//03
		Printer printer = ()->{
			Scanner sc = new Scanner(System.in);
			System.out.print("값 입력 : ");
			return sc.next();
			};
		String returnValue = printer.print();
		System.out.println(returnValue);
	}
}
