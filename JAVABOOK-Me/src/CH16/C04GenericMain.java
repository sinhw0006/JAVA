package CH16;

class Animal{
	public String name;
	
}
class Panda extends Animal{

	@Override
	public String toString() {
		return "Panda [name=" + name + "]";
	}

	public Panda(String name) {
		this.name = name;
	}
	
}
class Tiger extends Animal{

	@Override
	public String toString() {
		return "Tiger [name=" + name + "]";
	}

	public Tiger(String name) {
		this.name = name;
	}
	
}

public class C04GenericMain {
	public static <T extends Animal> void PrintByGeneric(T[] arr) {
		for (T t : arr) {
			System.out.println(t);
		}
		
	}
	public static void PrintByObject(Object[] arr) {
		for (Object object : arr) {
			System.out.println(object);
		}
	}
	public static void main(String[] args) {
		Animal[] arr = {new Tiger("호랑이"),new Panda("판다")}; 
		PrintByGeneric(arr);
		Object arr3[] = {new Tiger("호랑이"),new Panda("판다")};
		PrintByObject(arr3);
	}
}
