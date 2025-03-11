package CH16;

class Couple<T extends Person,T2 extends Person>{
	T Man;
	T2 Woman;
	@Override
	public String toString() {
		return "Couple [Man=" + Man + ", Woman=" + Woman + "]";
	}
	public Couple(T man, T2 woman) {
		super();
		Man = man;
		Woman = woman;
	}
}
class Person{
	String name;
	int age;
	String addr;
	@Override
	public String toString() {
		return "Man [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}
	public Person(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
}
class Man extends Person{
	public Man(String name, int age, String addr) {
		super(name, age, addr);
	}
}

class Woman extends Person{
	public Woman(String name, int age, String addr) {
		super(name, age, addr);
	}
}
public class C03GenericMain {
	public static void main(String[] args) {
		Couple<Man,Woman> couple = new Couple(new Man("홍길동", 11, "대구"), new Man("홍길동", 11, "대구"));
		System.out.println(couple);
	}
}
