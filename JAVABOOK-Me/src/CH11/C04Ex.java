package CH11;

import java.util.Iterator;

//다음 2개의 static 가진 ArrayUtils 클래스를 만들어보자.
//다음 코드의 실행 결과를 참고하여 concat()와 print()를 작성하여 ArrayUtil 클래스를 완성하라.

class ArrayUtils {
	public static int[] concat(int[] a, int[] b) {
		/* 배열 a와 b를 연결한 새로운 배열 리턴 */
		int length = a.length+b.length;
		int[] concat = new int[length];
		for(int i = 0; i<a.length; i++) {
			concat[i] = a[i];
		}
		for(int i = a.length; i<length;i++) {
			concat[i] = b[i-a.length];
		}
		return concat;
	}
	public static void print(int[] a) {
		for (int i : a) {
			System.out.printf("%d ",i);	
		}
		System.out.println();
	}

}

public class C04Ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1 = { 1, 5, 7, 9 };
		int[] array2 = { 3, 6, -1, 100, 77 };
		int[] array3 = ArrayUtils.concat(array1, array2);
		ArrayUtils.print(array3);
		String str1 = "Programming";
		String str2 = "Programming";
		String str3 = new String("Programming");
		
		println(str1==str2);
		println(str1==str3);
		println(str1.equals(str3));
		println(str2.equals(str3));
	}

	private static void println(boolean b) {
		if(b) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}
}
