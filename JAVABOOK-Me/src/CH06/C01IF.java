package CH06;

import java.util.*;

public class C01IF {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("세 개의 정수 입력 : ");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		int max = num1 > num2 ? num1: num2;
		max = max > num3 ? max : num3;
		System.out.printf("%d이 최대값입니다", max);
	}
}
