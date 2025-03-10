package CH15;

class Animal {
}

class Dog extends Animal {
}

class Cat extends Animal {
}

public class C03ClassCastExceptionMain {

	public static void changeDog(Animal animal) {
		try {
			Dog down = (Dog) animal;
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		Animal poppi = new Dog();
		Animal tori = new Cat();
		
		changeDog(tori);
		changeDog(poppi);
		
		System.out.println("HELLO WORLD");
		try {
			//예외 가능성이 있는 코드
		}catch (Exception e) {
			// 예외시 처리할 코드
		}finally {
			// 무조건 실행 코드
		}
				
	}
	
}
