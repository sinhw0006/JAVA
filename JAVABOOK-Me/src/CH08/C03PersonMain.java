package CH08;

class C03Person{
	String name;
	int age;
	float height;
	double weight;
	void talk() {System.out.printf("%s 님이 말을합니다.\n",this.name);};
	void walk() {System.out.printf("%s 님이 걷습니다.\n",this.name);};
	void showInfo() {
		System.out.printf("%s %d %f %f\n", this.name,this.age,this.height,this.weight);
	}
	@Override
	public String toString() {
		return "C03Person [name=" + name + ", age=" + age + ", height=" + height + ", weight=" + weight + "]";
	};
	// 객체정보 확인(toString)
	
}

public class C03PersonMain {
	public static void main(String[] args) {
		C03Person hong = new C03Person();
		hong.name="홍길동";
		hong.age=15;
		hong.height = 177.5f;
		hong.weight = 70.5;
		
		hong.talk();
		hong.walk();
		hong.showInfo();
		System.out.println(hong.toString());
	}
}
