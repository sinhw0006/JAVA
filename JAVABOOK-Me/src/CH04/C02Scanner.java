package CH04;

import java.util.Scanner;

public class C02Scanner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		System.out.printf("정수 입력 : ");
//		int num1 = Integer.parseInt(sc.next());
//		System.out.println("입력된 정수 값 : " + num1);
//
//		System.out.printf("실수 입력 : ");
//		double num2 = Double.parseDouble(sc.next());
//		System.out.println("입력된 실수 값 : " + num2);
//
//		System.out.printf("문자열 입력 : ");
//		String str1 = sc.next();
//		System.out.println("입력된 문자열 값 : " + str1);
//		System.out.printf("문자열 3개 입력 : ");
//		String s1 = sc.next();
//		String s2 = sc.next();
//		String s3 = sc.next();
//		System.out.printf("입력된 문자열 값 : %s %s %s\n",s1,s2,s3);
		
		System.out.print("문자열 입력(띄어쓰기 포함) : ");
		String str2 = sc.nextLine();
		System.out.println("문자열 : "+str2);
		sc.close();
		}
}
