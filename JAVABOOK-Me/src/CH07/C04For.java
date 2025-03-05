package CH07;

public class C04For {
	public static void main(String[] args) {
//		int i = 0;
//		while(i<10) {
//			System.out.println("Hello World");
//			i++;
//		}
		for(int i = 0; i<4; i++) {
			for(int j = 0; j<3-i; j++) {
				System.out.print(" ");
			}
			for(int j= 0; j<=2*i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
}
