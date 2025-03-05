package CH08;
import java.util.Scanner;

class MethodTest {
	Scanner sc = new Scanner(System.in);
	public int sum1(int n1, int n2) {
		return n1 + n2;
	}
	public int sum2() {
		System.out.print("두 수를 입력하세요 : ");
		return sc.nextInt() + sc.nextInt();
	}
	public void sum3(int n1, int n2) {
		System.out.println(n1+n2);
	}
	public void sum4() {
		System.out.print("두 수를 입력하세요 : ");
		System.out.println(sc.nextInt()+sc.nextInt());
	}
}

public class C04MethodMain {
	public static void main(String[] args) {
		MethodTest a = new MethodTest();
		System.out.println(a.sum1(5,6));
		System.out.println(a.sum2());
		a.sum3(11,22);
		a.sum4();
	}
}
