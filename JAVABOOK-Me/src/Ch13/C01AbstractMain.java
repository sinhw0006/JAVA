package Ch13;


//일반 클래스 상속관계
class Super1{
	void func() {}	// 완성된 함수
}
class Sub1 extends Super1{
	void func() {System.out.println("Overrided..Sub1.func()...Call!");}
}

//추상 클래스 상속관계 
abstract class Super2{
	abstract void func();	// 미완성된 완성
}
class Sub2 extends Super2{

	@Override
	void func() {
		System.out.println("Overrided..Sub2.func()...Call!");
	}	
}

public class C01AbstractMain {

	public static void main(String[] args) {
//		//01
//		Super1 ob1 = new Super1(); 	// 상위클래스형으로 객체생성 가능
//		Sub1 ob2 = new Sub1();		// 하위클래스형으로 객체생성 가능
//		Super1 ob3 = new Sub1();	// Upcasting 가능
//		ob3.func();					// 재정의된 함수 접근 가능
		
		//02 추상클래스 상속 관계
		//Super2 ob1 = new Super2(); 	// 상위클래스형으로 객체생성 불가능
		Sub2 ob2 = new Sub2();		// 하위클래스형으로 객체생성 가능(조건:미완성된함수->완성)
		Super2 ob3 = new Sub2();	// Upcasting 가능
		ob3.func();					// 재정의된 함수 접근 가능
	}

}
