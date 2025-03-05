package CH10;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class C02ArrayMain {
	public static void main(String[] args) {
		int arr1[] = {10,20,30};
		int arr2[];
		int arr3[] = arr1.clone();
		arr2 = arr1;
		arr1[0] = 100;
		arr2[1] = 50;
		Arrays.stream(arr1).forEach(System.out::println);
		System.out.println("==========================");
		Arrays.stream(arr2).forEach(System.out::println);
		System.out.println("==========================");
		Arrays.stream(arr3).forEach(System.out::println);
	}
}
