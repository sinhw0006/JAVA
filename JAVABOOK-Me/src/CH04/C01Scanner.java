package CH04;

import java.util.Scanner;

public class C01Scanner {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.printf("num1 입력 : ");
		int num1 = scanner.nextInt();
		
		System.out.printf("num2 입력 : ");
		int num2 = scanner.nextInt();
		
		System.out.printf("num3 입력 : ");
		int num3 = scanner.nextInt();
		
		System.out.printf("num4 입력 : ");
		int num4 = scanner.nextInt();
		
		int sum = num1 + num2 + num3 + num4;
		System.out.printf("%d + %d + %d + %d = %d\n", num1,num2,num3,num4,sum);
		
		System.out.printf("입력 : ");
		System.out.println(scanner.next().equals("a"));
		System.out.printf("입력 : ");
		System.out.println(scanner.next());
		scanner.close();
		}
}
