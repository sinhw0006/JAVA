package CH10;

public class C05MainParam {
	public static void main(String[] args) {
		System.out.println("length : "+args.length);
		for (String string : args) {
			System.out.println(string);
		}
	}
}
