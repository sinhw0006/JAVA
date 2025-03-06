package CH11;

class Company{
	int n1;
	int n2;
	private static Company instance;

	@Override
	public String toString() {
		return "Company [n1=" + n1 + ", n2=" + n2 + "]";
	}
	
	private Company() {}
	
	public static Company getInstance() {
		if(instance==null)
			instance = new Company();
		return instance;
	}
}

public class C03SingletonPattern {
	public static void main(String[] args) {
		Company com1 = Company.getInstance();
		Company com2 = Company.getInstance();
		com1.n1=100;
		com2.n2=100;
		System.out.println(com1);
		System.out.println(com2);
	}
}
