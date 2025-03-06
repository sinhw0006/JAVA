package CH11;

class C01Simple{
	int num1;
	int num2;
	
	public C01Simple() {
		num1=0;
		num2=0;
	}

	public C01Simple(int num1, int num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}

	@Override
	public String toString() {
		return "C01Simple [num1=" + num1 + ", num2=" + num2 + "]";
	}
	
}

public class C01StaticMain {
	public static void main(String[] args) {
		C01Simple ob1 = new C01Simple(10, 20);
		C01Simple ob2 = new C01Simple(30, 40);
		
		System.out.println(ob1);
		System.out.println(ob2);
	}
}
