package CH14;

class C02Simple{
	int n;

	public C02Simple(int n) {
		super();
		this.n = n;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof C02Simple) {
			C02Simple down = (C02Simple)obj;
			return this.n == down.n; 
		}
		return false;
	}
}

public class C02ObjectMain {
	public static void main(String[] args) {
		C02Simple ob1 = new C02Simple(10);
		C02Simple ob2 = new C02Simple(10);
		C02Simple ob3 = new C02Simple(20);
		System.out.println(ob1.equals(ob2));
		System.out.println(ob1.equals(ob3));
		
		String str1 = new String("Java");
		String str2 = new String("Java");
		System.out.println(str1.equals(str2));
	}
}
