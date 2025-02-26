package CH03;

public class C04TypeChange {
	public static void main(String[] args) {
		byte x = 10;
		byte y = 20;
		byte result1 = (byte)(x+y);
		
		int result2 = x+y;
		System.out.println(result1);
		
		byte var1 = 10;
		byte var2 = 100;
		long var3 = 1000L;
		int result = var1+var2+(int)var3;
		
		long resut2 = var1+var2+var3;
		
		int intvar = 10;
		float flvar = 3.3F;
		double dbvar = 5.5;
		int result3 = intvar+(int)(flvar+dbvar);
		double result4 = intvar + flvar + dbvar;
	}
}
