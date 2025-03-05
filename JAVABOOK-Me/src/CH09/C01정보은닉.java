package CH09;

import CH09.C01Person;

//접근 한정자
//멤버/클래스의 접근범위를 제한을 위한 예약어
//public		: 모든 클래스에서 접근가능
//private		: 해당 클래스에서만 접근가능
//protected		: 상속 관계를 가지는 경우에 접근가능
//default(기본)	: 동일 패키지에 속한 클래스에서 접근가능

class C01Person{
	private String name;
	private int age;
	String addr;
	
	public C01Person(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	//getter 함수(데이터를 외부로 반환)
	public String getName() {
		return this.name;
	}
	//setter 함수(기존데이터를 수정)
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getAge() {
		return age;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

public class C01정보은닉 {
	
	public static void main(String[] args) {
		
		C01Person person1 = new C01Person("홍길동",55,"대구");
		System.out.println(person1.getName());
		person1.setAge(56);
		
	}

}
