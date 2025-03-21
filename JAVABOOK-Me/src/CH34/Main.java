package CH34;

@CustomAnnotation(value = "Hello World!",number = 5)
class Simple{
	String v1;
	int v2;
	
	Simple(){
		CustomAnnotation ref = this.getClass().getAnnotation(CustomAnnotation.class);
		this.v1 = ref.value();
		this.v2 = ref.number();
	}
	
	@Override
	public String toString() {
		return "Simple [v1=" + v1 + ", v2=" + v2 + "]";
	}
	
}


public class Main {
	public static void main(String[] args) {
		Simple simple = new Simple();
		System.out.println(simple);
	}
}