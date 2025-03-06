package CH12;

class Animal{
	void sound() {System.out.println("소리");}
}
class Dog extends Animal{
	void sound() {System.out.println("멍멍");}
}

class Cat extends Animal{

}

public class C03MethodOverriding {
	public static void main(String[] args) {
		Animal ani = new Animal();
		Dog dog1 = new Dog();
		dog1.sound();
		Cat cat1 = new Cat();
		cat1.sound();
		System.out.println("=============================");
		ani = dog1;
		ani.sound();
		ani = cat1;
		ani.sound();
	}
}
