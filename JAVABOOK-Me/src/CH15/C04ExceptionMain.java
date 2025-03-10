package CH15;

public class C04ExceptionMain {
	public static void main(String[] args) throws Exception {
		String str = null;
		try {
			str.toString();
		} catch (NullPointerException e) {
			// TODO: handle exception
		}
		int arr[] = { 10, 20, 30 };
		try {
			arr[5] = 100;
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
		}		
		try {
			Integer.parseInt("a1234");	
		} catch (NumberFormatException e) {
			// TODO: handle exception
		}
		Animal animal = new Dog();
		try {
			Cat yummiCat = (Cat) animal;	
		} catch (ClassCastException e) {
			// TODO: handle exception
		}
		System.out.println("Hello World!");
	}
}
