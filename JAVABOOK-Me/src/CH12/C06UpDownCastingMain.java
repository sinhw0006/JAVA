package CH12;

class Super {
	int n1;
}

class Sub extends Super {
	int n2;
}
public class C06UpDownCastingMain {
	public static void main(String[] args) {
		// NoCasting(자료형의 일치)
		Super ob1 = new Super();
		ob1.n1 = 10;
		Sub ob2 = new Sub();
		ob2.n1 = 10;
		ob2.n2 = 10;

		// UpCasting(상위 클래스의 참조변수 = 하위클래스 객체, 자동 형변환)
		Super ob3 = new Sub();
		ob3.n1 = 100;
//      ob3.n2= 100;
		Super ob4 = ob2;
		ob4.n1 = 100;
//      ob4.n2= 100;
		
		// DownCasting(하위클래스 참조변수 = 상위클래스 객체, 강제 형변환)
		
		// 자식클래스에 부모클래스를 강제 형변환을 시도하면
		// 메모리 영역을 침범할 가능성이 있기 떄문에 오류가 발생한다.
		Sub ob5 = (Sub)ob1;  
		// 업캐스팅 된 상태인 부모클래스를 다시 다운캐스팅하면 
		// 메모리 영역에 자식클래스의 정보가 이미 담겨있기 떄문에
		// 오류가 발생하지 않는다.
		Sub ob6 = (Sub)ob3;
		
		
		
		
		
		
		
	}
}