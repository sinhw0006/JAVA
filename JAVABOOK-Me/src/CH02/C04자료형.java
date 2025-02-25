package CH02;

public class C04자료형 {
	public static void main(String[] args) {
		// int
		int n1 = 0b10101101;
		int n2 = 173;
		int n3 = 0255;
		int n4 = 0Xad;
//		System.out.printf("%d %d %d %d\n",n1,n2,n3,n4);
		// Byte
		byte n5 = (byte)-129;
		byte n6 = -30;
		byte n7 = 30;
		byte n8 = 127;
//		byte n9 = 128; // 1바이트 표현 값 초과
//		System.out.printf("%d\n", n9);
//		System.out.println(0b10101101);
//		System.out.println(Integer.toBinaryString(-129));
//
		char n10 = 65535;
		short n11 = 32767;
		char n12 = 60000;
//		short n13 = n12;
//		System.out.printf("%d\n",n13);
		
		// long - 8byte
		long n14 = 10000000000L;
		long n15 = 20; // 리터럴접미사 L,l
//		long n16 = 10000000000;
		long n17 = 10000000000L;
		
		// 정밀도
		float n18 = 0.123456789123456789F;	
		double n19 = 0.123456789123456789;
		System.out.println(n18);
		System.out.println(n19);
		// 오차 확인
		float num = 0.1F;
		for(int i =0; i<=1E4;i++) {
			num = num + 0.1F;
			System.out.println("num : "+num);
		}
	}
}
