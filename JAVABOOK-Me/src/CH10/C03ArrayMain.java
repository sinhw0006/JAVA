package CH10;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class C03ArrayMain {
	public static void main(String[] args) {
		int arr[][] ={
				{10,20,30},
				{40,50,60,65,67},
				{70,80,90,96,11,56},
				{100,110,120,15,22,33,44},
		};
		System.out.println("길이 : " + arr.length);
		System.out.println("길이 : " + arr[0].length);
		System.out.println("길이 : " + arr[1].length);
		System.out.println("길이 : " + arr[2].length);
		System.out.println("길이 : " + arr[3][0]);
		
	}
}
