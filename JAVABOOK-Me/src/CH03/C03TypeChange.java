package CH03;

public class C03TypeChange {
	public static void main(String[] args) {
		int num1 = 0b00000000000111111100000000100001;
		int num2 = 0b01111111110000001100000001111010;
		byte ch1 = (byte)num1;
		byte ch2 = (byte)num2;
		
		System.out.printf("num1 : %d  ch1 : %d\n", num1,ch1);
		System.out.printf("num2 : %d  ch2 : %d\n", num2,ch2);
		
	}
}
