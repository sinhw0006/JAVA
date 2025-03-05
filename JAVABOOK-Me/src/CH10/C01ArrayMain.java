package CH10;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class C01ArrayMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int [] arr1 = new int[5];
		
		System.out.print("5개 값입력 : ");
		arr1[0] = scanner.nextInt();
		arr1[1] = scanner.nextInt();
		arr1[2] = scanner.nextInt();
		arr1[3] = scanner.nextInt();
		arr1[4] = scanner.nextInt();
//		for (int i : arr1) {
//			System.out.println(i);
//		}
//		Arrays.stream(arr1).forEach(System.out::println); // el -> System.out.println(el)
		
		// 배열에 입력된 정수중에 최대값과 최소값 출력
		int max = -2147483647, min = 2147483647;
		for (int i : arr1) {
			if(max<i) max = i;
			if(min>i) min = i;
		}
		System.out.println("Max : "+max+"\nMin : "+min);
	}
}
