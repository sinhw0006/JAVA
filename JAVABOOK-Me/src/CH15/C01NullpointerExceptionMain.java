package CH15;

public class C01NullpointerExceptionMain {
	public static void main(String[] args) {
		String str = null;
		try {
			System.out.println(str.toString());
		} catch (Exception e) {
			System.out.println(e);
			System.out.println(e.getCause());
			System.out.println(e.toString());
			System.out.println(e.getStackTrace());
			e.printStackTrace();
		}
		System.out.println("Hello World");
		System.out.println("Hello World");
	}
}
