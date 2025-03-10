package CH16;

class 호빵<T> {
	private T meterial;

	호빵(T meterial) {
		this.meterial = meterial;
	}

	@Override
	public String toString() {
		return "호빵 [meterial=" + meterial + "]";
	}

}

class 호빵재료{
	
}

class 야채 extends 호빵재료{

	@Override
	public String toString() {
		return "야채";
	}
}

class 민초{

	@Override
	public String toString() {
		return "민트초코";
	}
}

class 슈크림 extends 호빵재료{

	@Override
	public String toString() {
		return "슈크림";
	}
}

class 팥 extends 호빵재료{

	@Override
	public String toString() {
		return "단팥";
	}
}

public class C01GenericMain {
	public static void main(String[] args) {
		호빵<호빵재료> a = new 호빵<>(new 팥());
		호빵<호빵재료> b = new 호빵<>(new 슈크림());
		호빵<호빵재료> c = new 호빵<>(new 야채());
//		호빵<호빵재료> d = new 호빵<>(new 민초());
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
//		System.out.println(d);
	}
}
