package CH12;

class C08Super{
	void func1() {System.out.println("C08.Super.func1() Call!");}
}
class C08Sub extends C08Super{
	void func2() {System.out.println("C08.Sub.func2() Call!");}
}
public class C08UpDownCastingMain {
	
	public static void main(String[] args) {
		C08Super ob1 = new C08Super();
		ob1.func1();
		System.out.println("===========");
		C08Sub ob2 = new C08Sub();
		ob2.func1();
		ob2.func2();
		System.out.println("===========");
		C08Super ob3 = new C08Sub();
		ob3.func1();
//		ob3.func2();
	}
}