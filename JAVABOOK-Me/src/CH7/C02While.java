package CH7;

import java.awt.datatransfer.SystemFlavorMap;
import java.util.Scanner;

public class C02While {
	
	public static void main(String[] args) {
		
		
		//2단 - 9단 출력
//		dan	i
//		2	1-9
//		3	1-9
//		...
//		9	1-9
//		---------------------------
//		dan=2	i=1
//		dan++	i++
//		dan<10   i<10
		
//		int dan = 2;
//		while(dan<10) {
//			
//			int i=1;
//			while(i<10) {
//				System.out.printf("%d x %d = %d\n", dan,i,dan*i);
//				i++;
//			}
//			System.out.println();
//			
//			dan++;
//		}
 	
		
		//2단 - 9단 출력 (2x9,2x8 ,.... 9x9 ,...9x1)
//		--------------------------
//		dan	i
//		2	9-1
//		3	9-1
//		...
//		9	9-1
//		---------------------------
//		dan=2	i=9
//		dan++	i--
//		dan<10   i>0

//		int dan = 2;
//		while(dan<10) {
//			
//			int i=9;
//			while(i>0) {
//				System.out.printf("%d x %d = %d\n", dan,i,dan*i);
//				i--;
//			}
//			System.out.println();
//			
//			dan++;
//		}
		
		
		//9단 - 2단( 9x9 9x8 - 2x1)
//		--------------------------
//		dan	i
//		9	9-1
//		8	9-1
//		...
//		2	9-1
//		---------------------------
//		dan=9	i=9
//		dan--	i--
//		dan>1   i>0

//		int dan = 9;
//		while(dan>1) {
//			
//			int i=9;
//			while(i>0) {
//				System.out.printf("%d x %d = %d\n", dan,i,dan*i);
//				i--;
//			}
//			System.out.println();
//			
//			dan--;
//		}		

		
		//2단 - N단(N<9)
		
		
//		입력 : n
//		dan	i
//		2	1-9
//		3	1-9
//		...
//		n	1-9
//		---------------------------
//		dan=2	i=1
//		dan++	i++
//		dan<n+1   i<10

//		Scanner sc = new Scanner(System.in);
//		System.out.print("단 수 입력 : " );
//		int n = sc.nextInt();
//		
//		//(N<9)
//		while(n>9 || n<2) {
//			System.out.println("2  - 9 사이의 값을 입력하세요" );
//			System.out.print("단 수 입력 : " );
//			n = sc.nextInt();	
//		}
//		
//		int dan = 2;
//		while(dan<n+1) {
//			
//			int i=1;
//			while(i<10) {
//				System.out.printf("%d x %d = %d\n", dan,i,dan*i);
//				i++;
//			}
//			System.out.println();
//			
//			dan++;
//		}
		
		
		//N단 - M단(N<M , N<9 , M<9)

		
		//별찍기(기본높이:4)
		

		//*****
		//*****
		//*****
		//*****
		Scanner sc = new Scanner(System.in);
		System.out.print("높이 값 : ");
		int a = sc.nextInt();
		
		int i = 0, j = 0;
		while(i<a) {
			while(j<5) {
				System.out.print("*");
				j++;
			}
			System.out.println();
			j = 0;
			i++;
		}
		i = 0;
		System.out.println("========================================");
	
		
		//*
		//**
		//***
		//****
		while(i<a) {
			j = 0;
			while(j<i+1) {
				System.out.print("*");
				j++;
			}
			System.out.println();
			i++;
		}
		i = 0;
		System.out.println("========================================");
		//****
		//***
		//**
		//*
		while(i<a) {
			j = 0;
			while(j<a-i) {
				System.out.print("*");
				j++;
			}
			System.out.println();
			i++;
		}
		i = 0;
		System.out.println("========================================");

		
		//   *
		//  ***
		// *****
		//*******
		int k = 0;
		while(i<a) {
			j = 0;
			k = 0; 
			while(k<a-1-i) {
				System.out.print(" ");
				k++;
			}
			while(j<(i*2)+1) {
				System.out.print("*");
				j++;
			}
			System.out.println();
			i++;
		}
		i = 0;
		k = 0;
		System.out.println("========================================");
	
		
		//*******
		// *****
		//  ***
		//   *
		while(i<a) {
			j = 0;
			k = 0; 
			while(k<i) {
				System.out.print(" ");
				k++;
			}
			while(j<(a-i)*2-1) {
				System.out.print("*");
				j++;
			}
			System.out.println();
			i++;
		}
		i = 0;
		k = 0;
		System.out.println("========================================");
		
		
		//   *
		//  ***
		// *****		
		//*******
		// *****
		//  ***
		//   *
		while(i<a-1) {
			j = 0;
			k = 0; 
			while(k<a-1-i) {
				System.out.print(" ");
				k++;
			}
			while(j<(i*2)+1) {
				System.out.print("*");
				j++;
			}
			System.out.println();
			i++;
		}
		i = 0;
		k = 0;
		while(i<a) {
			j = 0;
			k = 0; 
			while(k<i) {
				System.out.print(" ");
				k++;
			}
			while(j<(a-i)*2-1) {
				System.out.print("*");
				j++;
			}
			System.out.println();
			i++;
		}
		i = 0;
		k = 0;
		
		
		System.out.println("========================================");

		
		//*******
		// *****
		//  ***
		//   *		
		//   *
		//  ***
		// *****		
		//*******
		while(i<a-1) {
			j = 0;
			k = 0; 
			while(k<i) {
				System.out.print(" ");
				k++;
			}
			while(j<(a-i)*2-1) {
				System.out.print("*");
				j++;
			}
			System.out.println();
			i++;
		}
		i = 0;
		k = 0;
		while(i<a) {
			j = 0;
			k = 0; 
			while(k<a-1-i) {
				System.out.print(" ");
				k++;
			}
			while(j<(i*2)+1) {
				System.out.print("*");
				j++;
			}
			System.out.println();
			i++;
		}
		i = 0;
		k = 0;
	}
	
}
