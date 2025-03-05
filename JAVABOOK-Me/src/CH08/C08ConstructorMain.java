package CH08;

//생성자 매서드 => 객체 생성시에 필요한 메모리공간 형성과 "초기값 부여"에 사용
//객체 생성시 한번만 호출되는 매서드
//생성된 객체 내에서는 사용이 불가능
//생성자 매서드 이름은 클래스명과 동일, 반환 X
class C08Simple{
	int n1;
	double n2;
	boolean n3;
	String n4;
	C08Simple(){}
	C08Simple(int n1){
		System.out.println("C08Simple(int n1) 호출");
		this.n1 = n1;
	}
	C08Simple(int n1, double n2){
		System.out.println("C08Simple(int n1, double n2) 호출");
		this.n1 = n1;
		this.n2 = n2;
	}
	C08Simple(int n1, double n2, boolean n3){
		System.out.println("C08Simple(int n1, double n2, boolean n3) 호출");
		this.n1 = n1;
		this.n2 = n2;
		this.n3 = n3;
	}
//	C08Simple(int n1, double n2, boolean n3, String n4) {
//		System.out.println("C08Simple(int n1, double n2, boolean n3, String n4) 호출");
//		this.n1 = n1;
//		this.n2 = n2;
//		this.n3 = n3;
//		this.n4 = n4;
//	}
	
	
	
	
	@Override
	public String toString() {
		return "C08Simple [n1=" + n1 + ", n2=" + n2 + ", n3=" + n3 + ", n4=" + n4 + "]";
	}
public C08Simple(int n1, double n2, boolean n3, String n4) {
	super();
	this.n1 = n1;
	this.n2 = n2;
	this.n3 = n3;
	this.n4 = n4;
}
	
}

public class C08ConstructorMain {
	public static void main(String[] args) {
		C08Simple aa = new C08Simple();
		C08Simple a = new C08Simple(1);
		C08Simple b = new C08Simple(2,1.56);
		C08Simple c = new C08Simple(3,2.67,true);
		C08Simple d = new C08Simple(4,504.2,false,"Hello World!");
		System.out.println(a.toString());
		System.out.println(b.toString());
		System.out.println(c.toString());
		System.out.println(d.toString());
	}
}
